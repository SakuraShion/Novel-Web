package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.Book;
import org.example.novelcommon.mapper.BookMapper;
import org.example.novelcommon.service.BookService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book(小说表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




