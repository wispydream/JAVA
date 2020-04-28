package com.cloud.ribbon.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service                        // bean自动创建注解
public class HelloService {
    //// @Autowired Field注入方式（IDEA不推荐的注入方式）
    //// 注入resttemplate
    //@Autowired                  // 依赖注入注解：Spring Boot中的Field注入
    //RestTemplate restTemplate;

    // @Autowired构造器注入方式
    private final RestTemplate restTemplate;

    @Autowired
    public HelloService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sayHello() {
        //通过rest调用 调用provider服务 客户端负载均衡组件
        return restTemplate.getForObject("http://microservice-provider/hello", String.class);
    }
}
