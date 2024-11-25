package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.BookContent;
import org.example.novel.novel.service.BookContentService;
import org.example.novel.novel.mapper.BookContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_content(小说内容表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class BookContentServiceImpl extends ServiceImpl<BookContentMapper, BookContent>
    implements BookContentService {
    @Autowired
    private BookContentMapper bookContentMapper;

    @Override
    public List<BookContent> list(Map map) {
        List<BookContent> bookContents=bookContentMapper.list(map);
        return null;
    }

}




