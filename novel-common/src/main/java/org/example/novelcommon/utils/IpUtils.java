package org.example.novelcommon.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.utils
 * @Project：my
 * @Date：21/11/2024 3:07 pm
 */
public class IpUtils {
    public static String getRealIp(HttpServletRequest request){
        String ip=request.getHeader("X-Real-IP");
        if (ip==null||ip.length()==0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip!=null&&ip.contains(",")){
            String[] split = ip.split(".");
            ip=split[0];
        }
        return ip;
    }
}
