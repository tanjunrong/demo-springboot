package com.tanjr.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanjr.demo.controller.demo.vo.DemoVO;
import com.tanjr.demo.mapper.DemoMapper;
import com.tanjr.demo.pojo.Demo;
import com.tanjr.demo.service.DemoService;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
    @Override
    public List<Demo> listDemo(DemoVO demoVO) {
        return baseMapper.selectList(new LambdaQueryWrapper<Demo>().eq(Demo::getName, demoVO.getName()));
    }
}
