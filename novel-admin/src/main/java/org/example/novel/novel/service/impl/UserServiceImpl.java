package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.User;
import org.example.novel.novel.service.UserService;
import org.example.novel.novel.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




