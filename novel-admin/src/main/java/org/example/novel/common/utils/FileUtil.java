package org.example.novel.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @Author：hb
 * @Package：org.example.novel.common.utils
 * @Project：my
 * @Date：22/11/2024 3:23 pm
 */
public class FileUtil {
    public static void uploadFile(byte[] file,String filePath,String fileName)throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream outputStream=new FileOutputStream(filePath+fileName);
        outputStream.write(file);
        outputStream.flush();
        outputStream.close();
    }
    public static boolean deleteFile(String name){
        File targetFile = new File(name);
        if (targetFile.exists()&&targetFile.isFile()){
            if(targetFile.delete()){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public static String renameToUUID(String fileName) {
        return UUID.randomUUID()+"."+fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
