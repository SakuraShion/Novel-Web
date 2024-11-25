package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.UserFeedback;
import org.example.novelcommon.service.UserFeedbackService;
import org.example.novelcommon.mapper.UserFeedbackMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user_feedback】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback>
    implements UserFeedbackService{

}




