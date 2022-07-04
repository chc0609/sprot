package com.hezong.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: sprot
 * @ClassName CommonUtil
 * @description: 公有接口服务
 * @author: chenhuichao
 * @create: 2022-06-30 17:27
 **/
public interface CommonUtilService {

    Map<String,Object> uploadFile(MultipartFile file,String monthFile);
}
