package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.BookComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 15268
* @description 针对表【book_comment(小说评论表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.BookComment
*/
public interface BookCommentMapper extends BaseMapper<BookComment> {

    List<BookComment> list();
}




