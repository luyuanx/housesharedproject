package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Owner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OwnerMapper extends BaseMapper<Owner> {


    /**
     * 查询所有的房东信息
     */
    List<Owner> queryOwnerAll(Owner owner);




}
