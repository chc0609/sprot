package com.hezong.controller;

import com.alibaba.fastjson.JSON;
import com.hezong.pojo.Product;
import com.hezong.pojo.QueryProInfo;
import com.hezong.service.CommonUtilService;
import com.hezong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 产品控制器
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CommonUtilService commonUtilService;
    //获取查询产品和进行分页操作
    @RequestMapping("/allProduct")
    @ResponseBody
    public Map<String, Object> getAllProduct(QueryProInfo queryProInfo) {
        return productService.getAllProduct(queryProInfo);
    }


    //添加产品的方法
    @RequestMapping("/addProduct")
    public String addUser(@RequestBody Product product){
        System.out.println(product);
        int i = productService.addProduct(product);
        return i > 0 ? "success" : "error";
    }

    //删除用户的方法
    @RequestMapping("/deleteProduct")
    public String deleteProduct(int id){
        int i =productService.deleteProduct(id);
        return i > 0 ? "success" : "error";
    }

    //更新前获取用户的ID信息方法
    @RequestMapping("/getProductById")
    public String getProductById(int id){
        Product product = productService.getProductById(id); //根据ID查询到产品
        String s = JSON.toJSONString(product);
        return s;
    }

    //更新前根据查询到的用户进行修改
    @RequestMapping("/editProduct")
    public String editProduct(@RequestBody Product product){
        int i = productService.editProductById(product);
        return i > 0 ? "success" : "error";
    }


    /**
     * 前端接受产品图片将产品保存到本地，并将图片存入数据库
     * @param id
     * @return
     */
    @RequestMapping("/addProImage")
    @ResponseBody
    public Map<String, Object> addProImage(int id, MultipartFile file){
        Map<String,Object> map = commonUtilService.uploadFile(file);
        if(!(boolean)map.get("success")){
            return map;
        }
        String fileName = (String) map.get("fileName");
        int i = productService.updateImage(id,fileName);
        if(i<=0){
            map.put("success",false);
            map.put("message","保存入库失败！");
            return map;
        }
        return map;
    }
}
