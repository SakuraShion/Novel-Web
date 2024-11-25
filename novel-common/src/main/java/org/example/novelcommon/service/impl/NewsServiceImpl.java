package org.example.novelcommon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novelcommon.domain.News;
import org.example.novelcommon.mapper.NewsMapper;
import org.example.novelcommon.service.NewsService;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【news(新闻表)】的数据库操作Service实现
* @createDate 2024-11-21 11:37:52
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

}



