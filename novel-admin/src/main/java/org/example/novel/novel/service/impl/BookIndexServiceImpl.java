package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.BookIndex;
import org.example.novel.novel.service.BookIndexService;
import org.example.novel.novel.mapper.BookIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_index(小说目录表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class BookIndexServiceImpl extends ServiceImpl<BookIndexMapper, BookIndex>
    implements BookIndexService {
    @Autowired
    private BookIndexMapper bookIndexMapper;

    @Override
    public List<BookIndex> list(Map map) {
        return bookIndexMapper.list(map);
    }
}




