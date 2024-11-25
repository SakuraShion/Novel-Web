package org.example.novel.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.example.novel.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * @Author：hb
 * @Package：org.example.novel.common.utils
 * @Project：my
 * @Date：21/11/2024 5:01 pm
 */
public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;
    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static SysUser getUser(){
        return (SysUser) getSubjct().getPrincipal();
    }
    public static Long getUserId(){
        return getUser().getUserId();
    }
    public static void logout(){
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples(){
        List<Principal> principals=null;
        Collection<Session> sessions=sessionDAO.getActiveSessions();
        return principals;
    }

}
