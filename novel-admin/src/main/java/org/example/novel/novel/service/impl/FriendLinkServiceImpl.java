package org.example.novel.novel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.novel.domain.FriendLink;
import org.example.novel.novel.service.FriendLinkService;
import org.example.novel.novel.mapper.FriendLinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【friend_link】的数据库操作Service实现
* @createDate 2024-11-22 16:14:17
*/
@Service
public class FriendLinkServiceImpl extends ServiceImpl<FriendLinkMapper, FriendLink>
    implements FriendLinkService{

    @Autowired
    private FriendLinkMapper friendLinkMapper;

    @Override
    public List<FriendLink> list(Map map) {
        friendLinkMapper.list(map);
    }
}




