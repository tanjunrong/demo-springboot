package com.tanjr.demo.controller;

import com.tanjr.demo.common.ResponseData;
import com.tanjr.demo.controller.demo.vo.DemoVO;
import com.tanjr.demo.pojo.Demo;
import com.tanjr.demo.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("示例")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/list")
    @ApiOperation("所有项目")
    public ResponseData<List<Demo>> list(@RequestBody @Validated DemoVO demoVO) {
        List<Demo> list = demoService.listDemo(demoVO);
        // Demo demo = demoService.selectOne(new EntityWrapper<Project>().last("limit 1"));
        return ResponseData.success(list);
    }

    @GetMapping("/get")
    @ApiOperation("所有项目")
    public ResponseData<Demo> getDemo(Integer demoId) {
        Demo demo = demoService.getById(demoId);
        return ResponseData.success(demo);
    }


}
