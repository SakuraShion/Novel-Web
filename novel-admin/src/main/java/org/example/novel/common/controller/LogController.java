package org.example.novel.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.novel.common.domain.PageDO;
import org.example.novel.common.domain.SysLog;
import org.example.novel.common.service.SysLogService;
import org.example.novel.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.common.controller
 * @Project：my
 * @Date：22/11/2024 1:06 pm
 */
@RequestMapping("/common/log")
@Controller
public class LogController {
    @Autowired
    SysLogService logService;
    String prefix = "common/log";

    @GetMapping()
    String log() {
        return prefix + "/log";
    }

    @ResponseBody
    @GetMapping("/list")
    PageDO<SysLog> list(@RequestParam Map<String, Object> params) {
        PageDO<SysLog> page = logService.queryList(params);
        return page;
    }

    @ResponseBody
    @PostMapping("/remove")
    private R remove(Long id) {
        QueryWrapper<SysLog> sysLogQueryWrapper=new QueryWrapper<>();
        sysLogQueryWrapper.eq("id",id);
        boolean remove = logService.remove(sysLogQueryWrapper);
        if (remove==false){
            return R.error("删除失败");
        }
        return R.ok("删除成功");
    }
    @ResponseBody
    @PostMapping("/batchRemove")
    private R batchRemove(@RequestParam("ids[]") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        boolean b = logService.removeBatchByIds(list);
        if (b==false){
            return R.error("删除失败");
        }
        return R.ok("删除成功");
    }
}
