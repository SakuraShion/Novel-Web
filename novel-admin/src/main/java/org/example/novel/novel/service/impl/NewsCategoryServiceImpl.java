package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.NewsCategory;
import org.example.novel.novel.service.NewsCategoryService;
import org.example.novel.novel.mapper.NewsCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【news_category(新闻类别表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory>
    implements NewsCategoryService{

    @Autowired
    private NewsCategoryMapper newsCategoryMapper;

    @Override
    public List<NewsCategory> list(Map map) {
        newsCategoryMapper.list(map);
    }
}




