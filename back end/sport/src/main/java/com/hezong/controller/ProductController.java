package com.hezong.controller;

import com.alibaba.fastjson.JSON;
import com.hezong.pojo.QueryInfo;
import com.hezong.pojo.QueryProInfo;
import com.hezong.pojo.User;
import com.hezong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * 产品控制器
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    //获取查询用户和进行分页操作
    @RequestMapping("/allProduct")
    public Map<String, Object> getUserList(QueryProInfo queryProInfo) {



        String res_string = JSON.toJSONString(res); //转换为json字符串传给前端
        return res_string;
    }

    //更新用户状态
    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {

        int i = productService.updateState(id, state);
        return i > 0 ? "success" : "error";
    }

    //添加用户的方法
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        user.setRole("普通用户"); //初始化状态
        user.setState(false);//初始化状态
        int i = productService.addUser(user);
        return i > 0 ? "success" : "error";
    }

    //删除用户的方法
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        int i =userService.deleteUser(id);
        return i > 0 ? "success" : "error";
    }

    //更新前获取用户的ID信息方法
    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        User user = userService.getUpdateUser(id); //根据ID查询到用户
        String s = JSON.toJSONString(user);
        return s;
    }

    //更新前根据查询到的用户进行修改
    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        int i = userService.editUser(user);
        return i > 0 ? "success" : "error";
    }
}
