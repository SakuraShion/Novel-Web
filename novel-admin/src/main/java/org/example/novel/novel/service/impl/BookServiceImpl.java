package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.xxyopen.util.IdWorker;
import org.example.novel.common.service.SysFileService;
import org.example.novel.novel.domain.Book;
import org.example.novel.novel.domain.Dto.AtaCount;
import org.example.novel.novel.mapper.BookAuthorMapper;
import org.example.novel.novel.mapper.BookContentMapper;
import org.example.novel.novel.mapper.BookIndexMapper;
import org.example.novel.novel.service.AuthorService;
import org.example.novel.novel.service.BookService;
import org.example.novel.novel.mapper.BookMapper;
import org.example.novelcommon.cache.CacheService;
import org.example.novelcommon.mapper.BookCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book(小说表)】的数据库操作Service实现
* @createDate 2024-11-23 11:34:34
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

    @Autowired
    private BookMapper bookMapper;


    @Override
    public Book get(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> list(Map map) {
        return bookMapper.list(map);
    }

    @Override
    public Map<Object, Object> tableSta(Date minDate) {
        List<AtaCount>  ataCounts=bookMapper.count(minDate);
    }
}




