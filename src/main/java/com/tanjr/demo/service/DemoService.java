package com.tanjr.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanjr.demo.controller.demo.vo.DemoVO;
import com.tanjr.demo.pojo.Demo;

import java.util.List;

public interface DemoService extends IService<Demo> {

    List<Demo> listDemo(DemoVO demoVO);

}
