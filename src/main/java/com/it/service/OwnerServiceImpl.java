package com.it.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.entity.Owner;
import com.it.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OwnerService")
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper,Owner> implements OwnerService  {

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public PageInfo<Owner> queryOwnerAll(int page, int limit, Owner owner) {
        List<Owner> owners = ownerMapper.queryOwnerAll(owner);
        PageHelper.startPage(page, limit);
        PageInfo<Owner> pageInfo = new PageInfo<>(owners);
        return pageInfo;
    }

    @Override
    public int add(Owner owner) {
        int insert = baseMapper.insert(owner);
        return insert;
    }

    @Override
    public int delete(List<String> ids) {
        int count=0;
        for (String id : ids) {
            int i = baseMapper.deleteById(id);
            if (i>0) count++;
        }
        return count;
    }

    @Override
    public int updateData(Owner owner) {
        return baseMapper.updateById(owner);
    }

    @Override
    public Owner queryOwnerById(Integer id){
        Owner owner  = new Owner();
        owner.setId(id);
        List<Owner> owners = baseMapper.queryOwnerAll(owner);
        return owners.get(0);
    }
}
