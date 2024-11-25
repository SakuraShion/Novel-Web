package org.example.novel.common.mapper;

import org.example.novel.common.domain.SysGenColumns;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 15268
* @description 针对表【sys_gen_columns】的数据库操作Mapper
* @createDate 2024-11-21 16:43:27
* @Entity mp.domain.SysGenColumns
*/
public interface SysGenColumnsMapper extends BaseMapper<SysGenColumns> {

    SysGenColumns selectByTableName(String tableName);
}




