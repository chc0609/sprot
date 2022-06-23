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
    public List<Product> getAllProduct(QueryProInfo queryProInfo) {
        Map<String, Object> res = new HashMap<>();
        String queryName = null;
        if()
        //查询用户总数，模糊查询用户的总数,
        int counts = getProductCounts("%" + queryName + "%");
        //分页公式(当前页数-1)*每页最大数
        int pageStart = (queryProInfo.getPageNum() - 1) * queryProInfo.getPageSize();

        //获取所有的用户,并进行分页操作
        List<User> users = getAllUser("%" + queryProInfo.getUsername() + "%", pageStart, queryProInfo.getPageSize());
        res.put("counts", counts); //把总条数存入map
        res.put("users", users); //把所有用户存入map
        return productDao.getAllProduct(productName,oem,pageStart,pageSize);
    }

    @Override
    public int getProductCounts(String queryName) {
        return 0;
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
    public int editProductById(Product user) {
        return 0;
    }

    @Override
    public void updateImage(int id) {

    }
}
