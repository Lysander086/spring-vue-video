package com.example.system.controller;

import com.example.server.domain.Test;
import com.example.server.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/list")
    public List<Test> list() {
        System.out.println("point here");
        return testService.list();
    }

}
