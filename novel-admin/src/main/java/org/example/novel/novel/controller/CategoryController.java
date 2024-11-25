package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.NewsCategory;
import org.example.novel.novel.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：25/11/2024 1:20 pm
 */
@RestController
@RequestMapping("/novel/category")
public class CategoryController {
    @Autowired
    private NewsCategoryService categoryService;


    @ApiOperation(value = "获取新闻类别表列表", notes = "获取新闻类别表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<NewsCategory> categoryList = categoryService.list(params);
        PageBean pageBean = new PageBean(categoryList, categoryList.size());
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "修改新闻类别表页面", notes = "修改新闻类别表页面")
    @GetMapping("/getInfo/{id}")
    @ResponseBody
    public R edit(@PathVariable("id") Integer id) {
        NewsCategory byId = categoryService.getById(id);
        return R.ok().put("category", byId);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "新增新闻类别表", notes = "新增新闻类别表")
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody NewsCategory category) {
        if (categoryService.save(category) ) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改新闻类别表", notes = "修改新闻类别表")
    @ResponseBody
    @RequestMapping("/update")
    public R update( @RequestBody NewsCategory category) {
        categoryService.updateById(category);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除新闻类别表", notes = "删除新闻类别表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (categoryService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除新闻类别表", notes = "批量删除新闻类别表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        categoryService.removeBatchByIds(list);
        return R.ok();
    }
}
