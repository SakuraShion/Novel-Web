package org.example.novel.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.system.domain.SysUser;
import org.example.novel.system.service.SysUserService;
import org.example.novel.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 15268
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2024-11-21 17:07:02
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




