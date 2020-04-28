package com.wenlong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 15:02 2018/10/24
 * @ Description：${description}
 * @ Modified By：
 */
@RestController
public class TestController {

    @Value("${name}")
    private String name;

    @RequestMapping("/test")
    public String test(){
        return name;
    }
}
