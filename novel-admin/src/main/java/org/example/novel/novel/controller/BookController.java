package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.Book;
import org.example.novel.novel.service.BookService;
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
 * @Date：23/11/2024 11:30 am
 */
@Controller
@RequestMapping("/novel/book")
public class BookController {
    @Autowired
    private BookService bookService;



    @ApiOperation(value = "获取小说表列表", notes = "获取小说表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<Book> bookList = bookService.list(params);
        PageBean pageBean = new PageBean(bookList, bookList.size());
        return R.ok().put("data", pageBean);
    }


    @ApiOperation(value = "查看小说表页面", notes = "查看小说表页面")
    @GetMapping("/detail/{id}")
     private R detail(@PathVariable("id") Long id) {
        Book book = bookService.get(id);
        return R.ok().put("book",book);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增小说表", notes = "新增小说表")
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody Book book) {
        if (bookService.save(book)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改小说表", notes = "修改小说表")
    @ResponseBody
    @RequestMapping("/update")
    public R update( @RequestBody Book book) {
        bookService.updateById(book);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除小说表", notes = "删除小说表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove( Long id) {
        if (bookService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除小说表", notes = "批量删除小说表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        bookService.removeBatchByIds(list);
        return R.ok();
    }

}
