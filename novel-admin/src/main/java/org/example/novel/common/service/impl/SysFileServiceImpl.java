package org.example.novel.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.novel.common.domain.SysFile;
import org.example.novel.common.service.SysFileService;
import org.example.novel.common.mapper.SysFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 15268
* @description 针对表【sys_file(文件上传)】的数据库操作Service实现
* @createDate 2024-11-21 16:43:27
*/
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile>
    implements SysFileService{
    @Autowired
    private SysFileMapper sysFileMapper;

    @Override
    public List<SysFile> listAll(Map map) {
        return sysFileMapper.selectByContion(map);
    }

    @Override
    public SysFile getOneById(Long id) {
        SysFile sysFile = sysFileMapper.selectById(id);
        return sysFile;
    }

    @Override
    public int remove(Long id) {
        return sysFileMapper.deleteById(id);
    }
}




