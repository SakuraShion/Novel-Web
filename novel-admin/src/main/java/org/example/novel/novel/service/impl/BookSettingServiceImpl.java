package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.BookSetting;
import org.example.novel.novel.service.BookSettingService;
import org.example.novel.novel.mapper.BookSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_setting(首页小说设置表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class BookSettingServiceImpl extends ServiceImpl<BookSettingMapper, BookSetting>
    implements BookSettingService {
    @Autowired
    private BookSettingMapper bookSettingMapper;

    @Override
    public List<BookSetting> list(Map map) {
        return bookSettingMapper.list(map);
    }
}




