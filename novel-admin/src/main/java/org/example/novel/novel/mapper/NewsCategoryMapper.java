package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.NewsCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【news_category(新闻类别表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.NewsCategory
*/
public interface NewsCategoryMapper extends BaseMapper<NewsCategory> {

    List<NewsCategory> list(Map map);
}




