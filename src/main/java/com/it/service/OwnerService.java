package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.entity.Owner;

import java.util.List;

public interface OwnerService {


    /**
     * 分页查询户主信息
     */
    PageInfo<Owner> queryOwnerAll(int page, int limit, Owner owner);

    /**
     * 添加功能
     */
    int add(Owner owner);

    /**
     * 删除房主信息
     */
    int delete(List<String> ids);

    /**
     * 修改
     */
    int updateData(Owner owner);


    Owner queryOwnerById(Integer id);

}


