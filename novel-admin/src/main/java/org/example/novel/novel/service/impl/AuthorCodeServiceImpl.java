package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.AuthorCode;
import org.example.novel.novel.service.AuthorCodeService;
import org.example.novel.novel.mapper.AuthorCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【author_code(作家邀请码表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:16
*/
@Service
public class AuthorCodeServiceImpl extends ServiceImpl<AuthorCodeMapper, AuthorCode>
    implements AuthorCodeService {
    @Autowired
    private AuthorCodeMapper authorCodeMapper;

    @Override
    public List<AuthorCode> list(Map map) {
        List<AuthorCode> authorCodes=authorCodeMapper.list(map);
        return authorCodes;
    }
}




