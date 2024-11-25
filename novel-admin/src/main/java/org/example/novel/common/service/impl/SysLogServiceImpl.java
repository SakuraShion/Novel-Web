package org.example.novel.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.common.domain.PageDO;
import org.example.novel.common.domain.SysLog;
import org.example.novel.common.service.SysLogService;
import org.example.novel.common.mapper.SysLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_log(系统日志)】的数据库操作Service实现
* @createDate 2024-11-21 16:43:27
*/
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog>
    implements SysLogService{
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public PageDO<SysLog> queryList(Map<String, Object> params) {
        List<SysLog> sysLogs = sysLogMapper.queryList(params);
        PageDO<SysLog> pageDO=new PageDO<>();
        pageDO.setRows(sysLogs);
        pageDO.setTotal(sysLogs.size());
        return pageDO;
    }
}




