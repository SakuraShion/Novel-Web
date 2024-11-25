package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.Author;
import org.example.novelcommon.mapper.AuthorMapper;
import org.example.novelcommon.service.AuthorService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【author(作者表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:51
*/
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
    implements AuthorService {

}




