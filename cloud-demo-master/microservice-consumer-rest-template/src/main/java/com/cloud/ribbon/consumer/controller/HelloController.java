package com.cloud.ribbon.consumer.controller;


import com.cloud.ribbon.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController             // bean自动创建注解
public class HelloController {
    // 依赖注入注解 构造方法注入
    private final HelloService helloService;
    @Autowired              // 只有一个有参构造器，@Autowired注解可省略
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello(String name) {
        return "microservice-consumer-rest-template:" + helloService.sayHello();
    }
}
