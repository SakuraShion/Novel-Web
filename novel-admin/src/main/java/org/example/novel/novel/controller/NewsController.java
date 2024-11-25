package org.example.novel.novel.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.config.CacheKey;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.novel.domain.News;
import org.example.novel.novel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
 * @Date：25/11/2024 2:23 pm
 */

@RequestMapping("/novel/news")
@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @ApiOperation(value = "获取新闻表列表", notes = "获取新闻表列表")
    @ResponseBody
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<News> newsList = newsService.list(params);
        int total = newsList.size();
        PageBean pageBean = new PageBean(newsList, total);
        return R.ok().put("data", pageBean);
    }



    @ApiOperation(value = "查看新闻表页面", notes = "查看新闻表页面")
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        News byId = newsService.getById(id);
        return R.ok().put("news", byId);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "新增新闻表", notes = "新增新闻表")
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("novel:news:add")
    public R save(News news) {
        if (newsService.save(news)) {
            redisTemplate.delete(CacheKey.INDEX_NEWS_KEY);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改新闻表", notes = "修改新闻表")
    @ResponseBody
    @RequestMapping("/update")
    public R update(News news) {
        newsService.updateById(news);
        redisTemplate.delete(CacheKey.INDEX_NEWS_KEY);
        return R.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除新闻表", notes = "删除新闻表")
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Long id) {
        if (newsService.removeById(id)) {
            redisTemplate.delete(CacheKey.INDEX_NEWS_KEY);
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "批量删除新闻表", notes = "批量删除新闻表")
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        newsService.removeBatchByIds(list);
        redisTemplate.delete(CacheKey.INDEX_NEWS_KEY);
        return R.ok();
    }
}
