package org.example.novel.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.novel.common.domain.SysGenColumns;
import org.example.novel.common.service.SysGenColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.common.controller
 * @Project：my
 * @Date：22/11/2024 1:41 pm
 */
@RequestMapping("/common/generator")
@Controller
public class GeneratorController {
    String prefix = "common/generator";
    @Autowired
    private SysGenColumnsService generatorService;

    @Autowired
    private ObjectMapper objectMapper;
    @GetMapping()
    String generator() {
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    List<Map<String, Object>> list(String tableName) {
        QueryWrapper<SysGenColumns> sysGenColumnsQueryWrapper=new QueryWrapper<>();
        sysGenColumnsQueryWrapper.eq("tableName",tableName);
        List<SysGenColumns> list = generatorService.list(sysGenColumnsQueryWrapper);
        List<Map<String,Object>> result=new ArrayList<>();
        for (SysGenColumns sysGenColumns:list){
            Map<String, Object> map = BeanUtil.beanToMap(sysGenColumns);
            result.add(map);
        }
        return result;
    }
    @RequestMapping("/downLoadCode/{tableName}")
    public void downLoadCode(HttpServletRequest request, HttpServletResponse response,
                             @PathVariable("tableName") String tableName) throws IOException {
        String[] tableNames=new String[]{tableName};
        byte[] bytes = generatorService.downloadCode(tableNames);
    }
}
