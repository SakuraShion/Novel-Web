package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.BookComment;
import org.example.novel.novel.domain.vo.BookCommentVo;
import org.example.novel.novel.service.BookCommentService;
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
 * @Date：23/11/2024 9:40 am
 */
@Controller
@RequestMapping("/novel/bookComment")
public class BookCommentController {
    @Autowired
    private BookCommentService bookCommentService;


    @ApiOperation(value = "获取小说评论表列表", notes = "获取小说评论表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        List<BookComment> bookComments = bookCommentService.list(params);
        PageBean pageBean=new PageBean(bookComments,bookComments.size());
        return R.ok().put("bookComments",bookComments);
    }
    @ApiOperation(value = "新增小说评论表页面", notes = "新增小说评论表页面")
    @GetMapping("/add")
    public R add(@RequestBody BookComment bookComment){
        boolean save = bookCommentService.save(bookComment);
        return R.ok(String.valueOf(save));
    }

    @ApiOperation(value = "查看小说评论表页面", notes = "查看小说评论表页面")
    @GetMapping("/detail/{id}")
    public R getDetail(@PathVariable Long id){
        BookComment bookComment = bookCommentService.getById(id);
        return R.ok().put("bookComment",bookComment);
    }
    @ApiOperation(value = "根据书本查看评论", notes = "根据书本查看评论")
    @GetMapping("/book/{bookid}")
    public R getDetailByBookId(@PathVariable Long bookid){
        List<BookCommentVo> bookComments=bookCommentService.getCommentByBookId(bookid);
        return R.ok().put("bookComments",bookComments);
    }
    @ApiOperation(value = "删除小说评论表", notes = "删除小说评论表")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public R removeById(@PathVariable Long id){
        boolean b = bookCommentService.removeById(id);
        return R.ok(String.valueOf(b));
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除小说评论表", notes = "批量删除小说评论表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        bookCommentService.removeBatchByIds(list);
        return R.ok();
    }

}
