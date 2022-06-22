package com.hezong.service;

import com.hezong.pojo.MainMenu;

import java.util.List;

/**
 * 菜单业务层实现类
 */

public interface MenuService {
    //获取所有的菜单，因为主菜单中包含了子菜单
    List<MainMenu> getMenus();
}
