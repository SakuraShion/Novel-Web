package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.BookContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_content(小说内容表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.BookContent
*/
public interface BookContentMapper extends BaseMapper<BookContent> {

    List<BookContent> list(Map map);
}




