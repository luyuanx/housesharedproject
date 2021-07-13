package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.entity.Repair;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairMapper extends BaseMapper<Repair> {
     List<Repair> queryAllRepair(Repair repair);
}
