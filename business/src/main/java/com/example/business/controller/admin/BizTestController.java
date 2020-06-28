package com.example.business.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BizTestController {
    @RequestMapping("/biz/test")
    public String test() {
        log.info("biz test");
        return "gateway: biz final test";
    }

}
