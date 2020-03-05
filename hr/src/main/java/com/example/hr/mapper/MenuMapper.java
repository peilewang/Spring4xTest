package com.example.hr.mapper;

import com.example.hr.entity.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
