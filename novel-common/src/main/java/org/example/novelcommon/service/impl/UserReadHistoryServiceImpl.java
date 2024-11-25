package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.UserReadHistory;
import org.example.novelcommon.service.UserReadHistoryService;
import org.example.novelcommon.mapper.UserReadHistoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user_read_history(用户阅读记录表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class UserReadHistoryServiceImpl extends ServiceImpl<UserReadHistoryMapper, UserReadHistory>
    implements UserReadHistoryService{

}




