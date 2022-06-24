package com.hezong.service;

import com.hezong.pojo.Product;
import com.hezong.pojo.QueryProInfo;

import java.util.Map;

/**
 * @program: sprot
 * @ClassName ProductService
 * @description: 产品管理服务类
 * @author: chenhuichao
 * @create: 2022-06-23 19:40
 **/
public interface ProductService {
    //获取所有产品  pageStart:从哪里开始展示  pageSize：页面展示条数
    Map<String, Object> getAllProduct(QueryProInfo queryProInfo);

    //获取所有产品的个数
    int getProductCount(String productName);

    //添加产品的方法
    int addProduct(Product product);

    //删除用户的方法
    int deleteProduct(int id);

    //修改用户的方法
    Product getProductById(int id);//根据id查询出产品
    int editProductById(Product product);//根据查询出的产品进行修改

    //更新图片
    void updateImage(int id);
}
