package org.example.novel.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * @Author：hb
 * @Package：org.example.novel.common.utils
 * @Project：my
 * @Date：21/11/2024 5:23 pm
 */
public class JSONUtils {
    public static String beanToJson(Object object, String dataFormatString) {
        if (object!=null){
            if (StringUtils.isEmpty(dataFormatString)){
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object,dataFormatString);
        }
        return null;
    }
    public static String beanToJson(Object object) {
        if (object!=null){
            return JSON.toJSONString(object);
        }else {
            return null;
        }
    }
}
