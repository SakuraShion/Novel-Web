package org.example.novel.common.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.example.novel.common.config.Constant;
import org.example.novel.common.config.JnConfig;
import org.example.novel.common.domain.SysFile;
import org.example.novel.common.service.SysFileService;
import org.example.novel.common.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author：hb
 * @Package：org.example.novel.common.controller
 * @Project：my
 * @Date：22/11/2024 2:42 pm
 */
@Controller
@RequestMapping("/common/sysFile")
public class FileController extends BaseController{

    @Autowired
    private SysFileService sysFileService;

    @Autowired
    private JnConfig jnConfig;

    @ResponseBody
    @GetMapping("/list")
    public PageBean list(@RequestParam Map<String, Object> params) {
        List<SysFile> list = sysFileService.listAll(params);
        PageBean pageBean=new PageBean(list,list.size());
        return pageBean;
    }
    @PostMapping("/add")
    public R add(@RequestBody SysFile sysFile){
        boolean save = sysFileService.save(sysFile);
        if (save==true){
            return R.ok("添加成功");
        }
        return R.error("添加失败");
    }

    @GetMapping("/edit")
        // @RequiresPermissions("common:bComments")
    public R edit(@RequestBody SysFile sysFile) {
        boolean b = sysFileService.updateById(sysFile);
        if (b==true){
            return R.ok("编辑成功");
        }
        return R.error("编辑失败");
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("common:info")
    public R info(@PathVariable("id") Long id) {
        QueryWrapper<SysFile> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        SysFile one = sysFileService.getOne(queryWrapper);
        return R.ok().put("sysFile", one);
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    // @RequiresPermissions("common:remove")
    public R remove(Long id, HttpServletRequest request) {
        if ("test".equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        String fileName =
                jnConfig.getUploadPath() + sysFileService.getOneById(id).getUrl().replace(Constant.UPLOAD_FILES_PREFIX, "");
        if (sysFileService.remove(id) > 0) {
            boolean b = FileUtil.deleteFile(fileName);
            if (!b) {
                return R.error("数据库记录删除成功，文件删除失败");
            }
            return R.ok();
        } else {
            return R.error();
        }
    }

    @PostMapping("/batchRemove")
    @ResponseBody
    public R remove(@RequestParam("ids[]") Long[] ids) {
        if ("test".equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        List<Long> list = Arrays.asList(ids);
        sysFileService.removeBatchByIds(list);
        return R.ok();
    }

    @ResponseBody
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if ("test".equals(getUsername())) {
            return R.error(1, "演示系统不允许修改,完整体验请部署程序");
        }
        Date date = new Date();
        String year = DateUtils.format(date, DateUtils.YEAR_PATTERN);
        String month = DateUtils.format(date, DateUtils.MONTH_PATTERN);
        String day = DateUtils.format(date, DateUtils.DAY_PATTERN);
        String filename = file.getOriginalFilename();
        String fileDir=year+"/"+month+"/"+day+"/";
        SysFile sysFile=new SysFile();
        sysFile.setCreateDate(date);
        sysFile.setUrl(Constant.UPLOAD_FILES_PREFIX+fileDir+filename);
        sysFile.setType(FileType.fileType(filename));
        try {

            FileUtil.uploadFile(file.getBytes(),jnConfig.getUploadPath(),filename);
        }catch (Exception e){
            return R.error();
        }
        if (sysFileService.save(sysFile)) {
            return R.ok().put("fileName", sysFile.getUrl());
        }
        return R.error();
    }
    /**
     * 文件下载
     */
    @RequestMapping(value = "/download")
    public void fileDownload(String filePath, String fileName, HttpServletResponse resp) throws Exception {
        String realFilePath = jnConfig.getUploadPath() + filePath;
        InputStream in = new FileInputStream(realFilePath);
        fileName=URLEncoder.encode(fileName,"UTF-8");
        resp.setHeader("Content-Disposition","attachment;filename="+fileName);
        resp.setContentLength(in.available());
        OutputStream outputStream = resp.getOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len=in.read(b))!=-1){
            outputStream.write(b,0,len);
        }
        outputStream.flush();
        outputStream.close();
        in.close();
        }

    }
