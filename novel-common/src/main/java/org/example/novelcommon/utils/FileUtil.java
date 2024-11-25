package org.example.novelcommon.utils;

import io.github.xxyopen.util.UUIDUtil;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Objects;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import javax.imageio.ImageIO;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.utils
 * @Project：my
 * @Date：21/11/2024 1:15 pm
 */
@UtilityClass
@Slf4j
public class FileUtil {
    /**
     * 网络图片转本地
     */
    public String network2Local(String picSrc, String picSavePath, String visitPrefix) {
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {
            //本地图片保存
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            ResponseEntity<Resource> resEntity = RestTemplateUtil.getInstance(Charsets.ISO_8859_1.name()).exchange(picSrc, HttpMethod.GET, requestEntity, Resource.class);
            inputStream = Objects.requireNonNull(resEntity.getBody().getInputStream());
            Date currentDay=new Date();
            picSrc=visitPrefix+DateUtil.formatDate(currentDay,"yyyy")+"/"+DateUtil.formatDate(currentDay,"MM")+"/"+DateUtil.formatDate(currentDay, "dd") + "/"+ UUIDUtil.getUUID32()+picSrc.substring(picSrc.lastIndexOf("."));
            File picFile=new File(picSavePath+picSrc);
            File parentFile = picFile.getParentFile();
            if (!parentFile.exists()){
                parentFile.mkdirs();
            }
            outputStream=new FileOutputStream(picFile);
            byte[] b=new byte[4096];
            for (int n;(n=inputStream.read(b))!=-1;){
                outputStream.write(b,0,n);
            }
            outputStream.flush();
            if (ImageIO.read(picFile) == null){
                picSrc="/images/default.gif";
            }

        }catch (Exception e){
            log.error(e.getMessage(), e);
            picSrc = "/images/default.gif";
        }finally {
            closeStream(inputStream,outputStream);
        }
        return picSrc;
    }
    @SneakyThrows
    private void closeStream(InputStream input, OutputStream out) {
        if (input!=null){
            input.close();
        }
        if (out!=null){
            out.close();
        }
    }
    @SneakyThrows
    private boolean isImage(File file){
        BufferedImage read = ImageIO.read(file);
        return read!=null;
    }

    @SneakyThrows
    private void writeContentToFile(String fileSavePath, String fileSrc, String content){
        OutputStream out = null;
        try {

            File file = new File(fileSavePath + fileSrc);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            out = new FileOutputStream(file);
            out.write(content.getBytes());
            byte[] b = new byte[4096];
            out.flush();
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            closeStream(null,out);
        }
    }
}
