package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.Author;
import org.example.novel.novel.service.AuthorService;
import org.example.novel.novel.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【author(作者表)】的数据库操作Service实现
* @createDate 2024-11-22 16:14:16
*/
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, Author>
    implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<Author> list(Map map) {
        List<Author> authors=authorMapper.list(map);
        return authors;
    }

    @Override
    public Map<Object, Object> tableSta(Date minDate) {
        return null;
    }
}




