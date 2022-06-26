package com.hezong.service.impl;

import com.hezong.dao.ProductDao;
import com.hezong.pojo.Product;
import com.hezong.pojo.QueryProInfo;
import com.hezong.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenhuichao
 * @className ProductServiceImpl
 * @description: 产品管理的实现类
 * @date 2022/6/23 23:06
 */
@Service
public class ProductServiceImpl implements ProductService {

    Logger logger = LoggerFactory.getLogger(getClass());
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
        List<Product> list = productDao.getAllProduct(queryProInfo.getQueryName(), pageStart, queryProInfo.getPageSize());
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        product.setUpdateTime(formatter.format(new Date()));
        productDao.addProduct(product);
        return 0;
    }

    @Override
    public int deleteProduct(int id) {
        return 0;
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public int editProductById(Product product) {
        return productDao.editProductById(product);
    }

    @Override
    public int updateImage(int id) {
        return 0;
    }
}
