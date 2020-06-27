package com.example.system.controller;

import com.example.system.domain.Test;
import com.example.system.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        return "hi world";
    }

    @GetMapping("/test2")
    public List<Test> test2() {
        return testService.list();
    }
}
