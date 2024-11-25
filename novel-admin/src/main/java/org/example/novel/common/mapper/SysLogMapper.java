package org.example.novel.common.mapper;

import org.example.novel.common.domain.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_log(系统日志)】的数据库操作Mapper
* @createDate 2024-11-21 16:43:27
* @Entity mp.domain.SysLog
*/
public interface SysLogMapper extends BaseMapper<SysLog> {

    List<SysLog> queryList(Map<String, Object> params);
}




