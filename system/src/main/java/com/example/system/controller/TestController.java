package com.example.system.controller;

import com.example.server.domain.Test;
import com.example.server.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        log.info("/system/test");
        return "gateway: final test";
    }

    @RequestMapping("/list")
    public List<Test> list() {
        return testService.list();
    }

}
