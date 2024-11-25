package org.example.novel.common.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.common.domain.SysGenColumns;
import org.example.novel.common.service.SysGenColumnsService;
import org.example.novel.common.mapper.SysGenColumnsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
* @author 15268
* @description 针对表【sys_gen_columns】的数据库操作Service实现
* @createDate 2024-11-21 16:43:27
*/
@Service
public class SysGenColumnsServiceImpl extends ServiceImpl<SysGenColumnsMapper, SysGenColumns>
    implements SysGenColumnsService{

    @Autowired
    private SysGenColumnsMapper sysGenColumns;


    @Override
    public byte[] downloadCode(String[] tableNames) {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        ZipOutputStream zip=new ZipOutputStream(outputStream);
        for (String tableName:tableNames){
            Map<String, Object> map = BeanUtil.beanToMap(sysGenColumns.selectByTableName(tableName));
        }
            return new byte[0];
    }
}




