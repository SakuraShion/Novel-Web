package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.BookIndex;
import org.example.novel.novel.service.BookIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：23/11/2024 1:46 pm
 */
@Controller
@RequestMapping("/novel/bookIndex")
public class BookIndexController {

    @Autowired
    private BookIndexService bookIndexService;

    @GetMapping()
    @RequiresPermissions("novel:bookIndex:bookIndex")
    String BookIndex() {
        return "novel/bookIndex/bookIndex";
    }

    @ApiOperation(value = "获取小说目录表列表", notes = "获取小说目录表列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("novel:bookIndex:bookIndex")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<BookIndex> bookIndexList = bookIndexService.list(params);
        int total =bookIndexList.size();
        PageBean pageBean = new PageBean(bookIndexList, total);
        return R.ok().put("data", pageBean);
    }


    @ApiOperation(value = "查看小说目录表页面", notes = "查看小说目录表页面")
    @GetMapping("/detail/{id}")
    @ResponseBody
    public R detail(@PathVariable("id") Long id) {
        BookIndex bookIndex = bookIndexService.getById(id);

        return R.ok().put("bookIndex",bookIndex);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增小说目录表", notes = "新增小说目录表")
    @ResponseBody
    @PostMapping("/save")
    public R save( @RequestBody BookIndex bookIndex) {
        if (bookIndexService.save(bookIndex)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改小说目录表", notes = "修改小说目录表")
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody BookIndex bookIndex) {
        bookIndexService.updateById(bookIndex);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除小说目录表", notes = "删除小说目录表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove( Long id) {
        if (bookIndexService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除小说目录表", notes = "批量删除小说目录表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        bookIndexService.removeBatchByIds(list);
        return R.ok();
    }

}
