package org.example.novel.novel.service;

import org.example.novel.novel.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.Map;

/**
* @author 15268
* @description 针对表【user】的数据库操作Service
* @createDate 2024-11-22 16:14:17
*/
public interface UserService extends IService<User> {

    Map<Object, Object> tableSta(Date minDate);
}
