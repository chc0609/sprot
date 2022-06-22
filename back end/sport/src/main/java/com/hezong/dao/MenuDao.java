package com.hezong.dao;

import com.hezong.pojo.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单持久层接口
 */
@Repository
public interface MenuDao {
    //获取所有的菜单，因为主菜单中包含了子菜单
    List<MainMenu> getMenus();
}
