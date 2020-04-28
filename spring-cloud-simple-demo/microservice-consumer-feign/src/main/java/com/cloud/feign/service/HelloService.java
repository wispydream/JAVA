package com.cloud.feign.service;

import com.cloud.feign.rpc.GetHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    //@Autowired
    //private GetHello getHello; //注入rpc

    // feign客户端对象注入
    private final GetHello getHello;

    public HelloService(GetHello getHello) {
        this.getHello = getHello;
    }

    public String sayHello(){
        return getHello.sayHello(); // 提供一个hello World
    }
}
