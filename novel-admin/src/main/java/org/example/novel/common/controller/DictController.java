package org.example.novel.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.config.Constant;
import org.example.novel.common.domain.SysDict;
import org.example.novel.common.mapper.SysDictMapper;
import org.example.novel.common.utils.PageBean;
import org.example.novel.common.utils.R;
import org.example.novel.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author：hb
 * @Package：org.example.novel.common.controller
 * @Project：my
 * @Date：22/11/2024 11:02 am
 */
@Controller
@RequestMapping("/common/dict")
public class DictController {
    @Autowired
    private SysDictMapper dictService;

    @ResponseBody
    @GetMapping("/list")
    public PageBean list(@RequestBody SysDict sysDict) {
        QueryWrapper<SysDict> sysDictQueryWrapper=new QueryWrapper<>();
        List<SysDict> list = dictService.list(sysDict);
        PageBean pageBean=new PageBean(list,list.size());
        return pageBean;
    }
    @GetMapping("/edit/{id}")
    public SysDict edit(@PathVariable("id") Long id) {
        QueryWrapper<SysDict> sysDictQueryWrapper=new QueryWrapper<>();
        sysDictQueryWrapper.eq("id",id);
        SysDict sysDict = dictService.selectById(id);
        return sysDict;
    }
    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(@RequestBody SysDict dict) {
        String username = ShiroUtils.getUser().getUsername();
        if (Constant.DEMO_ACCOUNT.equals(username)) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int result = dictService.insert(dict);
        if (result==1){
            return R.ok("添加成功");
        }
        return R.error("添加失败");
    }
    /**
     * 修改
     */

    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody SysDict dict) {
        String username = ShiroUtils.getUser().getUsername();
        if (Constant.DEMO_ACCOUNT.equals(username)) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int i = dictService.updateById(dict);
        return R.ok();
    }
    @PostMapping("/remove")
    @ResponseBody
    public R remove(@RequestParam Long id) {
        String username = ShiroUtils.getUser().getUsername();
        if (Constant.DEMO_ACCOUNT.equals(username)) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        int i = dictService.deleteById(id);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids") Long[] ids) {
        List<Long> list = Arrays.asList(ids);
        String username = ShiroUtils.getUser().getUsername();
        if (Constant.DEMO_ACCOUNT.equals(username)) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        dictService.deleteBatchIds(list);
        return R.ok();
    }
    @GetMapping("/type")
    @ResponseBody
    public List<SysDict> listType() {
        return dictService.listType();
    }

    @ResponseBody
    @GetMapping("/list/{type}")
    public PageBean listByType(@PathVariable("type") String type) {
        QueryWrapper<SysDict> dictQueryWrapper=new QueryWrapper<>();
        dictQueryWrapper.eq("type", type);
        List<SysDict> sysDicts = dictService.selectList(dictQueryWrapper);
        PageBean pageBean=new PageBean(sysDicts,sysDicts.size());
        return pageBean;

    }

}
