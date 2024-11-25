package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.BookSetting;
import org.example.novelcommon.mapper.BookSettingMapper;
import org.example.novelcommon.service.BookSettingService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【book_setting(首页小说设置表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class BookSettingServiceImpl extends ServiceImpl<BookSettingMapper, BookSetting>
    implements BookSettingService{

}




