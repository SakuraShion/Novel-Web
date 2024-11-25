package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.Author;
import org.example.novel.novel.service.AuthorService;
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
 * @Date：22/11/2024 5:13 pm
 */
@Controller
@RequestMapping("/novel/author")
public class AuthorController   {
    @Autowired
    private AuthorService authorService;

    @ApiOperation(value = "获取作者表列表", notes = "获取作者表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        List<Author> authorList = authorService.list(params);
        PageBean pageBean = new PageBean(authorList, authorList.size());
        return R.ok().put("data", pageBean);
    }
    @ApiOperation(value = "新增作者表页面", notes = "新增作者表页面")
    @GetMapping("/add")
    public R add(@RequestBody Author author){
        boolean save = authorService.save(author);
        return R.ok(String.valueOf(save));
    }
    @ApiOperation(value = "作者页面", notes = "作者页面")
    @GetMapping("/select/{id}")
    public R select(@PathVariable Long id){
        Author byId = authorService.getById(id
        );
        return R.ok().put("author",byId);
    }

    @ApiOperation(value = "修改作者表", notes = "修改作者表")
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody Author author){
        boolean b = authorService.updateById(author);
        return R.ok(String.valueOf(b));
    }
    @ApiOperation(value = "删除作者表", notes = "删除作者表")
    @PostMapping("/remove/{id}")
    @ResponseBody
    public R remove(@PathVariable Long id){
        boolean b = authorService.removeById(id);
        return R.ok(String.valueOf(b));
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除作者表", notes = "批量删除作者表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        authorService.removeBatchByIds(list);
        return R.ok();
    }
}
