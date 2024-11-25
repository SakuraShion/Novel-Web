package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book(小说表)】的数据库操作Mapper
* @createDate 2024-11-23 11:34:34
* @Entity org.example.novel.novel.domain.Book
*/
public interface BookMapper extends BaseMapper<Book> {
    List<Book> list(Map map);

}




