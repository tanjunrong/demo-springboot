package com.tanjr.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanjr.demo.controller.demo.vo.DemoVO;
import com.tanjr.demo.mapper.DemoMapper;
import com.tanjr.demo.pojo.Demo;
import com.tanjr.demo.service.DemoService;

import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
    @Override
    public List<Demo> listDemo(DemoVO demoVO) {        // Creating a KeyValue object
        MutablePair<Integer, String> kv
            = MutablePair.of(1,
            "GeeksForGeeks");

        // Using getKey() method
        int key = kv.getKey();

        // Printing the Key
        System.out.println(key);
        return baseMapper.selectList(new QueryWrapper<>());
    }
}
