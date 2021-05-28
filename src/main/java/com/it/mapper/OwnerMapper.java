package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Owner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OwnerMapper")
public interface OwnerMapper extends BaseMapper<Owner> {


    /**
     * 查询所有的户主信息
     */
    List<Owner> queryOwnerAll(Owner owner);




}
