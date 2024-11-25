package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【news(新闻表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.News
*/
public interface NewsMapper extends BaseMapper<News> {

    List<News> list(Map map);

}




