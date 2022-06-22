package com.hezong.service.impl;

import com.hezong.dao.MenuDao;
import com.hezong.pojo.MainMenu;
import com.hezong.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单业务层实现类
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    //获取所有的菜单，因为主菜单中包含了子菜单
    @Override
    public List<MainMenu> getMenus() {
        return menuDao.getMenus();
    }
}
