package org.example.novel.novel.service;

import org.example.novel.novel.domain.BookComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.novel.novel.domain.vo.BookCommentVo;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_comment(小说评论表)】的数据库操作Service
* @createDate 2024-11-22 16:14:17
*/
public interface BookCommentService extends IService<BookComment> {

    List<BookComment> list (Map map);


    List<BookCommentVo> getCommentByBookId(Long bookid);
}
