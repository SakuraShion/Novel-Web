package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.BookContent;
import org.example.novelcommon.mapper.BookContentMapper;
import org.example.novelcommon.service.BookContentService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_content(小说内容表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookContentServiceImpl extends ServiceImpl<BookContentMapper, BookContent>
    implements BookContentService{

}




