package org.example.novel.common.controller;

import org.example.novel.common.utils.ShiroUtils;
import org.example.novel.system.domain.SysUser;
import org.springframework.stereotype.Controller;

/**
 * @Author：hb
 * @Package：org.example.novel.common.controller
 * @Project：my
 * @Date：22/11/2024 11:01 am
 */
@Controller
public class BaseController {
    public SysUser getUser() {
        return ShiroUtils.getUser();
    }

    public Long getUserId() {
        return getUser().getUserId();
    }

    public String getUsername() {
        return getUser().getUsername();
    }
}
