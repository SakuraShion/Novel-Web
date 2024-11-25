package org.example.novel.common.mapper;

import org.example.novel.common.domain.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 15268
* @description 针对表【sys_dict(字典表)】的数据库操作Mapper
* @createDate 2024-11-21 16:43:27
* @Entity mp.domain.SysDict
*/
public interface SysDictMapper extends BaseMapper<SysDict> {
    List<SysDict> list(SysDict sysDict);

    List<SysDict> listType();
}




