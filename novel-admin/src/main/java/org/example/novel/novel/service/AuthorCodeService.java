package org.example.novel.novel.service;

import org.example.novel.novel.domain.AuthorCode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【author_code(作家邀请码表)】的数据库操作Service
* @createDate 2024-11-22 16:14:16
*/
public interface AuthorCodeService extends IService<AuthorCode> {
    List<AuthorCode> list(Map map);

}
