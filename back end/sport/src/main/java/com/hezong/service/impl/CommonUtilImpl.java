package com.hezong.service.impl;

import com.hezong.service.CommonUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: sprot
 * @ClassName CommonUtil
 * @description: 公有接口服务
 * @author: chenhuichao
 * @create: 2022-06-30 17:27
 **/
@Service
public class CommonUtilImpl implements CommonUtilService {
    Logger logger = LoggerFactory.getLogger(CommonUtilImpl.class);

    /**
     * 上传文件到本地,并删除原来文件
     * @param file
     * @return
     */
    public Map<String,Object> uploadFile(MultipartFile file,String monthFile){
        // 这个map用于返回imageUrl，imageId之类的数据
        Map<String,Object> map = new HashMap<>();
        try {
            // 1）设置文件的目录
            //按照月份进行分类：
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            String monthDirectory = formatter.format(new Date());
            String fileDirectory = "D:/IDEAProj/sprot/front end/sport/src/assets/image/"+monthDirectory;
            // 创建文件目录
            File realPath = new File(fileDirectory);  //上传文件保存地址：realPath = "E:\\图片保存\\upload\\2022年5月"
            if (!realPath.exists()){
                boolean mkdirs = realPath.mkdirs();//创建文件目录，可以创建多层目录
            }
            //2）设置文件名字
            String fileRealName = file.getOriginalFilename();
            String suffix = fileRealName.substring(fileRealName.lastIndexOf("."));  //后缀  jpg  png
            if(!(".png".equals(suffix)||".jpg".equals(suffix))){
                map.put("success",false);
                map.put("message","上传失败,文件格式错误");
                return map;
            }
            //解决文件名字问题：使用uuid的方式;
            String fileName = "file-"+ UUID.randomUUID().toString().replaceAll("-", "") + suffix;

            //3）进行文件保存，通过CommonsMultipartFile的方法直接写文件
            file.transferTo(new File(fileDirectory +"/"+ fileName));

            //4)删除原来图片
            File oldFile = new File("D:/IDEAProj/sprot/front end/sport/src/assets/image/"+monthFile);
            boolean isDelete = oldFile.delete();
            if (isDelete){
                logger.info("原图片文件删除成功");
            }else{
                logger.error("删除原文件失败");
            }
            map.put("success",true);
            map.put("message","上传成功");
            map.put("fileName",monthDirectory+"/"+fileName);
            return map;
        } catch (IOException e) {
            logger.error("CommonUtil.uploadFile:保存文件出错，出错信息："+e);
            map.put("success",false);
            map.put("message","上传失败");
            return map;
        }
    }
}
