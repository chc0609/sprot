package com.hezong.controller;

import com.alibaba.fastjson.JSON;
import com.hezong.pojo.Product;
import com.hezong.pojo.QueryProInfo;
import com.hezong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 产品控制器
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

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
        System.out.println(id+"*****************");
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

    //更新图片
    @RequestMapping("/updateImage")
    public String updateImage(int id){
        int i = productService.updateImage(id);
        return i > 0 ? "success" : "error";
    }
}
