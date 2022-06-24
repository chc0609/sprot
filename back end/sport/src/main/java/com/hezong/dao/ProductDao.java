package com.hezong.dao;

import com.hezong.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenhuichao
 * @className ProductDao
 * @description: 产品持久层接口
 * @date 2022/6/23 23:09
 */
@Repository
public interface ProductDao {
    //获取所有产品  pageStart:从哪里开始展示  pageSize：页面展示条数
    List<Product> getAllProduct(@Param("queryName") String queryName, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    //获取所有产品的个数
    int getProductCount(@Param("queryName") String queryName);

    //添加产品的方法
    int addProduct(Product product);

    //删除用户的方法
    int deleteProduct(int id);

    //修改用户的方法
    Product getProductById(int id);//根据id查询出用户
    int editProductById(Product user);//根据查询出的用户进行修改

    //更新图片
    void updateImage(int id);
}
