package com.tanjr.demo.service.impl;

import com.tanjr.demo.mapper.DemoMapper;
import com.tanjr.demo.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    DemoMapper demoMapper;
}
