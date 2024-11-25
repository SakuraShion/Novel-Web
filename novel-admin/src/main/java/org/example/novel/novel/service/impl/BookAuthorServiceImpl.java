package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.BookAuthor;
import org.example.novel.novel.service.BookAuthorService;
import org.example.novel.novel.mapper.BookAuthorMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_author(作者表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:16
*/
@Service
public class BookAuthorServiceImpl extends ServiceImpl<BookAuthorMapper, BookAuthor>
    implements BookAuthorService {

}




