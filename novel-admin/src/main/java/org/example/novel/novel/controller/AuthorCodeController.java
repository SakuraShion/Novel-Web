package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.AuthorCode;
import org.example.novel.novel.service.AuthorCodeService;
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
 * @Date：22/11/2024 4:39 pm
 */
@Controller
@RequestMapping("/novel/authorCode")
public class AuthorCodeController {
    @Autowired
    private AuthorCodeService authorCodeService;


    @ApiOperation(value = "获取作家邀请码表列表", notes = "获取作家邀请码表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        return R.ok().put("list",authorCodeService.list(params));
    }

    @ApiOperation(value = "新增作家邀请码表", notes = "新增作家邀请码表")
    @ResponseBody
    @PostMapping("/save")
    public R save( @RequestBody AuthorCode authorCode) {
        if (authorCodeService.save(authorCode)){
            return R.ok("新增成功");
        }
        return R.error("新增失败");
    }

    /**
     *
     *
     *修改
     */
    @ApiOperation(value = "修改作家邀请码表", notes = "修改作家邀请码表")
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody AuthorCode authorCode) {
        boolean b = authorCodeService.updateById(authorCode);
        return R.ok(String.valueOf(b));
    }

    @ApiOperation(value = "删除作家邀请码表", notes = "删除作家邀请码表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(@RequestParam Long id) {
        if (authorCodeService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    @ApiOperation(value = "批量删除作家邀请码表", notes = "批量删除作家邀请码表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        authorCodeService.removeBatchByIds(list);
        return R.ok();
    }
}
