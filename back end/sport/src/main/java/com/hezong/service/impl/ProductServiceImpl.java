package com.hezong.service.impl;

import com.hezong.dao.ProductDao;
import com.hezong.pojo.Product;
import com.hezong.pojo.QueryProInfo;
import com.hezong.pojo.User;
import com.hezong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenhuichao
 * @className ProductServiceImpl
 * @description: 产品管理的实现类
 * @date 2022/6/23 23:06
 */
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public Map<String, Object> getAllProduct(QueryProInfo queryProInfo) {
        Map<String, Object> res = new HashMap<>();
        //查询用户总数，模糊查询用户的总数,
        int count = getProductCount(queryProInfo.getQueryName());
        //分页公式(当前页数-1)*每页最大数
        int pageStart = (queryProInfo.getPageNum() - 1) * queryProInfo.getPageSize();

        //获取所有的产品,并进行分页操作
        List<Product> list = productDao.getAllProduct(queryProInfo.getQueryName(), queryProInfo.getPageNum(), queryProInfo.getPageSize());
        res.put("count", count); //把总条数存入map
        res.put("list", list); //把所有用户存入map
        return res;
    }

    @Override
    public int getProductCount(String queryName) {
        return productDao.getProductCount(queryName);
    }

    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public int deleteProduct(int id) {
        return 0;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public int editProductById(Product product) {
        return 0;
    }

    @Override
    public void updateImage(int id) {

    }
}
