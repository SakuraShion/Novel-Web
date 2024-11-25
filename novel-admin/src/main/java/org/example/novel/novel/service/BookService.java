package org.example.novel.novel.service;

import org.example.novel.novel.domain.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book(小说表)】的数据库操作Service
* @createDate 2024-11-23 11:34:34
*/
public interface BookService extends IService<Book> {

    Book get(Long id);
    List<Book> list (Map map);

    Map<Object, Object> tableSta(Date minDate);
}
