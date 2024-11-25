package org.example.novel.common.mapper;

import org.example.novel.common.domain.SysFile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_file(文件上传)】的数据库操作Mapper
* @createDate 2024-11-21 16:43:27
* @Entity mp.domain.SysFile
*/
public interface SysFileMapper extends BaseMapper<SysFile> {

    List<SysFile> selectByContion(Map map);
}




