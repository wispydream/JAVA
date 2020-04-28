package com.wenlong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 10:42 2018/10/19
 * @ Description：${description}
 * @ Modified By：
 */
@RestController
public class MenberController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<String> getMenberList(){
        List<String> list = new ArrayList();
        list.add("liming");
        list.add("zhangsan");
        list.add("wangwu");
        list.add(port);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }
}
