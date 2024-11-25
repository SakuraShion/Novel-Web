package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.UserBookshelf;
import org.example.novelcommon.service.UserBookshelfService;
import org.example.novelcommon.mapper.UserBookshelfMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user_bookshelf(用户书架表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class UserBookshelfServiceImpl extends ServiceImpl<UserBookshelfMapper, UserBookshelf>
    implements UserBookshelfService{

}




