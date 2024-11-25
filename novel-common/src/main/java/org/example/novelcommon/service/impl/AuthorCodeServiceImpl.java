package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.AuthorCode;
import org.example.novelcommon.mapper.AuthorCodeMapper;
import org.example.novelcommon.service.AuthorCodeService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【author_code(作家邀请码表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:51
*/
@Service
public class AuthorCodeServiceImpl extends ServiceImpl<AuthorCodeMapper, AuthorCode>
    implements AuthorCodeService {

}




