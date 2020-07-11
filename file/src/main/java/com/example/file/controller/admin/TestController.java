package com.example.file.controller.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // log for logging

    @Value("${file.path}")
    private String FILE_PATH;

    @RequestMapping("/test2")
    public String test(){
        return "hi";
    }

}
