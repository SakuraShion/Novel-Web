package org.example.novel.novel.mapper;

import org.example.novel.novel.domain.AuthorCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【author_code(作家邀请码表)】的数据库操作Mapper
* @createDate 2024-11-22 16:14:16
* @Entity mp.domain.AuthorCode
*/
public interface AuthorCodeMapper extends BaseMapper<AuthorCode> {

    List<AuthorCode> list(Map map);
}




