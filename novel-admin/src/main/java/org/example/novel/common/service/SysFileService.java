package org.example.novel.common.service;

import org.example.novel.common.domain.SysFile;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_file(文件上传)】的数据库操作Service
* @createDate 2024-11-21 16:43:27
*/
public interface SysFileService extends IService<SysFile> {

    List<SysFile> listAll(Map map);

    SysFile getOneById(Long id);

    int remove(Long id);
}
