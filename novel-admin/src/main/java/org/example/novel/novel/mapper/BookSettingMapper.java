package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.BookSetting;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【book_setting(首页小说设置表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.BookSetting
*/
public interface BookSettingMapper extends BaseMapper<BookSetting> {
    List<BookSetting> list(Map map);

}




