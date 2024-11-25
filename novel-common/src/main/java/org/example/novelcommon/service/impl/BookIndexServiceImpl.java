package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.BookIndex;
import org.example.novelcommon.mapper.BookIndexMapper;
import org.example.novelcommon.service.BookIndexService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_index(小说目录表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookIndexServiceImpl extends ServiceImpl<BookIndexMapper, BookIndex>
    implements BookIndexService{

}




