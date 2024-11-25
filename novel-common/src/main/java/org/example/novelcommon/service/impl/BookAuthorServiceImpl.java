package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.BookAuthor;
import org.example.novelcommon.mapper.BookAuthorMapper;
import org.example.novelcommon.service.BookAuthorService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_author(作者表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookAuthorServiceImpl extends ServiceImpl<BookAuthorMapper, BookAuthor>
    implements BookAuthorService{

}




