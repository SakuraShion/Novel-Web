package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.News;
import org.example.novel.novel.service.NewsService;
import org.example.novel.novel.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【news(新闻表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<News> list(Map map) {
        return newsMapper.list(map);
    }
}




