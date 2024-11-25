package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.config.CacheKey;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.BookSetting;
import org.example.novel.novel.service.BookSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.novel.controller
 * @Project：my
 * @Date：23/11/2024 2:32 pm
 */

@Controller
@RequestMapping("/novel/bookSetting")
public class BookSettingController {

    @Autowired
    private BookSettingService bookSettingService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @ApiOperation(value = "获取首页小说设置表列表", notes = "获取首页小说设置表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<BookSetting> bookSettingList = bookSettingService.list(params);
        int total = bookSettingList.size();
        PageBean pageBean = new PageBean(bookSettingList, total);
        return R.ok().put("data", pageBean);
    }

    @ApiOperation(value = "新增首页小说设置表", notes = "新增首页小说设置表")
    @ResponseBody
    @PostMapping("/save")
    public R save(BookSetting bookSetting) {
        if (bookSettingService.save(bookSetting)) {
            return R.ok();
        }
        redisTemplate.delete(CacheKey.INDEX_BOOK_SETTINGS_KEY);
        return R.error();
    }
    /**
     * 修改
     */
    @ApiOperation(value = "修改首页小说设置表", notes = "修改首页小说设置表")
    @ResponseBody
    @RequestMapping("/update")
    public R update(BookSetting bookSetting) {
        bookSettingService.updateById(bookSetting);
        redisTemplate.delete(CacheKey.INDEX_BOOK_SETTINGS_KEY);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除首页小说设置表", notes = "删除首页小说设置表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (bookSettingService.removeById(id)) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除首页小说设置表", notes = "批量删除首页小说设置表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        bookSettingService.removeBatchByIds(list);
        return R.ok();
    }
}

