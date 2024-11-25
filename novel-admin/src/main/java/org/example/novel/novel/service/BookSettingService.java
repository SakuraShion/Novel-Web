package org.example.novel.novel.service;

import org.example.novel.novel.domain.BookSetting;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_setting(首页小说设置表)】的数据库操作Service
* @createDate 2024-11-22 16:14:17
*/
public interface BookSettingService extends IService<BookSetting> {
    List<BookSetting> list(Map map);

}
