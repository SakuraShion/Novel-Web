package org.example.novel.novel.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.example.novel.novel.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-11-22 16:14:17
* @Entity mp.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    String getUserNameById(Long createUserId);

    @MapKey("staDay")
    List<Map<Object, Object>> tableSta(Date minDate);
}




