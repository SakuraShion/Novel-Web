package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.UserFeedback;
import org.example.novel.novel.service.UserFeedbackService;
import org.example.novel.novel.mapper.UserFeedbackMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user_feedback】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class UserFeedbackServiceImpl extends ServiceImpl<UserFeedbackMapper, UserFeedback>
    implements UserFeedbackService{

}




