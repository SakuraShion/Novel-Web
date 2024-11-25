package org.example.novel.novel.service;

import org.example.novel.novel.domain.Author;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【author(作者表)】的数据库操作Service
* @createDate 2024-11-22 16:14:16
*/
public interface AuthorService extends IService<Author> {
    List<Author> list(Map map);

}
