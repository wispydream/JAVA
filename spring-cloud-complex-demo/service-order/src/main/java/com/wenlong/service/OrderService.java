package com.wenlong.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 11:09 2018/10/19
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 接口出错或超时未响应启动服务降级，调用getOrderListError方法
     */
    @HystrixCommand(fallbackMethod = "getOrderListError")
    public List<String> getOrderList(){
        List<String> orderList = restTemplate.getForObject("http://service-member/list", List.class);
        return orderList;
    }

    public List<String> getOrderListError(){
        List<String> orderList = new ArrayList();
        orderList.add("restTemplate fallback");
        return orderList;
    }
}
