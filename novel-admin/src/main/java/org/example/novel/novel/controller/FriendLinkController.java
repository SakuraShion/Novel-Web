package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.config.CacheKey;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.FriendLink;
import org.example.novel.novel.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：25/11/2024 2:05 pm
 */
@RestController
@RequestMapping("/novel/friendLink")
public class FriendLinkController {

    @Autowired
    private FriendLinkService friendLinkService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @ApiOperation(value = "获取列表", notes = "获取列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<FriendLink> friendLinkList = friendLinkService.list(params);
        PageBean pageBean = new PageBean(friendLinkList, friendLinkList.size());
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "修改页面", notes = "修改页面")
    @GetMapping("/getInfo/{id}")
    @ResponseBody
    public R edit(@PathVariable("id") Integer id) {
        FriendLink friendLink = friendLinkService.getById(id);
        return R.ok().put("friendLink", friendLink);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增", notes = "新增")
    @ResponseBody
    @PostMapping("/save")
    public R save(@PathVariable FriendLink friendLink) {
        if (friendLinkService.save(friendLink)) {
            redisTemplate.delete(CacheKey.INDEX_LINK_KEY);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改", notes = "修改")
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody FriendLink friendLink) {
        friendLinkService.updateById(friendLink);
        redisTemplate.delete(CacheKey.INDEX_LINK_KEY);
        return R.ok();
    }
    /**
     * 删除
     */
    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (friendLinkService.removeById(id)) {
            redisTemplate.delete(CacheKey.INDEX_LINK_KEY);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除", notes = "批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        friendLinkService.removeBatchByIds(list);
        redisTemplate.delete(CacheKey.INDEX_LINK_KEY);
        return R.ok();
    }
}
