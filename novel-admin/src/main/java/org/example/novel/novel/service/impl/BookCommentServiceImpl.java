package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.BookComment;
import org.example.novel.novel.domain.vo.BookCommentVo;
import org.example.novel.novel.mapper.UserMapper;
import org.example.novel.novel.service.BookCommentService;
import org.example.novel.novel.mapper.BookCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_comment(小说评论表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class BookCommentServiceImpl extends ServiceImpl<BookCommentMapper, BookComment>
    implements BookCommentService {

    @Autowired
    private BookCommentMapper bookCommentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<BookComment> list(Map map) {
        List<BookComment> bookComments=bookCommentMapper.list();
        return bookComments;
    }

    @Override
    public List<BookCommentVo> getCommentByBookId(Long bookid) {
        QueryWrapper<BookComment> queryWrapper=new QueryWrapper<>();
        List<BookCommentVo> bookCommentVos=new ArrayList<>();
        List<BookComment> bookComments = bookCommentMapper.selectList(queryWrapper);
        for (BookComment bookComment:bookComments){
            BookCommentVo bookCommentVo=new BookCommentVo();
            bookCommentVo.setCommentContent(bookComment.getCommentContent());
            bookCommentVo.setBookId(bookid);
            bookCommentVo.setAuditStatus(bookComment.getAuditStatus());
            bookCommentVo.setUserId(bookComment.getCreateUserId());
            bookCommentVo.setCreateTime(bookComment.getCreateTime());
            bookCommentVo.setOppositionCount(bookComment.getOppositionCount());
            bookCommentVo.setSupportCount(bookComment.getSupportCount());
            bookCommentVo.setUserName(userMapper.getUserNameById(bookComment.getCreateUserId()));
            bookCommentVos.add(bookCommentVo);
        }
        return bookCommentVos;
    }
}




