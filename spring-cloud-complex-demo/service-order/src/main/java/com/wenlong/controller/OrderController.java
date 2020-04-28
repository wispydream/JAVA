package com.wenlong.controller;

import com.wenlong.service.OrderService;
import com.wenlong.service.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 11:13 2018/10/19
 * @ Description：${description}
 * @ Modified By：
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderServiceFeign orderServiceFeign;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<String> getOrderList(){
        List<String> list = orderService.getOrderList();
        list.add("service-order 使用RestTemplate调用 service-member");
        return list;
    }

    @RequestMapping(value = "/listFeign", method = RequestMethod.GET)
    public List<String> getMenberList(){
        List<String> list = orderServiceFeign.getMembers();
        list.add("service-order 使用Feign调用 service-member");
        return list;
    }

}
