package com.hezong.service;

import com.hezong.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: sprot
 * @ClassName ProductService
 * @description: 产品管理服务类
 * @author: chenhuichao
 * @create: 2022-06-23 19:40
 **/
public interface ProductService {
    //获取所有产品  pageStart:从哪里开始展示  pageSize：页面展示条数
    List<Product> getAllProduct(@Param("productName") String productName,@Param("oem") String oem, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取所有产品的个数
    int getProductCounts(@Param("productName") String productName,@Param("oem") String oem);

    //添加产品的方法
    int addProduct(Product product);

    //删除用户的方法
    int deleteUser(int id);

    //修改用户的方法
    Product getUpdateUser(int id);//根据id查询出用户
    int editUser(Product user);//根据查询出的用户进行修改
}
