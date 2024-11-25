package org.example.novel.common.service;

import org.example.novel.common.domain.PageDO;
import org.example.novel.common.domain.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_log(系统日志)】的数据库操作Service
* @createDate 2024-11-21 16:43:27
*/
public interface SysLogService extends IService<SysLog> {

    PageDO<SysLog> queryList(Map<String, Object> params);
}
