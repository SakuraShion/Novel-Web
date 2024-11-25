package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.UserBuyRecord;
import org.example.novelcommon.service.UserBuyRecordService;
import org.example.novelcommon.mapper.UserBuyRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【user_buy_record(用户消费记录表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class UserBuyRecordServiceImpl extends ServiceImpl<UserBuyRecordMapper, UserBuyRecord>
    implements UserBuyRecordService{

}




