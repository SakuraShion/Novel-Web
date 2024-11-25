package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.BookContent;
import org.example.novel.novel.service.BookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：23/11/2024 10:57 am
 */
@Controller
@RequestMapping("/novel/bookContent")
public class BookContentController {
    @Autowired
    private BookContentService bookContentService;


    @ApiOperation(value = "获取小说内容表列表", notes = "获取小说内容表列表")
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("novel:bookContent:bookContent")
    public R list(@RequestParam Map<String, Object> params) {
        List<BookContent> bookContentList = bookContentService.list(params);
        PageBean pageBean = new PageBean(bookContentList, bookContentList.size());
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "新增小说内容表", notes = "新增小说内容表")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("novel:bookContent:add")
    public R save( @RequestBody BookContent bookContent) {
        if (bookContentService.save(bookContent)) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "修改小说内容表", notes = "修改小说内容表")
    @ResponseBody
    @RequestMapping("/update")
    public R update( @RequestBody BookContent bookContent) {
        bookContentService.updateById(bookContent);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除小说内容表", notes = "删除小说内容表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove( Long id) {
        if (bookContentService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除小说内容表", notes = "批量删除小说内容表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        bookContentService.removeBatchByIds(list);
        return R.ok();
    }


}
