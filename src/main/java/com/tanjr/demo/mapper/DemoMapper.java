package com.tanjr.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanjr.demo.pojo.Demo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoMapper extends BaseMapper<Demo> { }
