package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.BookComment;
import org.example.novelcommon.mapper.BookCommentMapper;
import org.example.novelcommon.service.BookCommentService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_comment(小说评论表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookCommentServiceImpl extends ServiceImpl<BookCommentMapper, BookComment>
    implements BookCommentService{

}




