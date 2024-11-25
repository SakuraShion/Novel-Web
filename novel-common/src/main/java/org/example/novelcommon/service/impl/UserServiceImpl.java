package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.User;
import org.example.novelcommon.service.UserService;
import org.example.novelcommon.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




