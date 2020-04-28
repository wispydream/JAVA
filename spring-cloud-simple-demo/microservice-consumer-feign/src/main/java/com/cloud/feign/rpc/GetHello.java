package com.cloud.feign.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// feign客户端是用来访问ribbon-consumer微服务的（目标服务）
@FeignClient(value = "microservice-provider")
public interface GetHello {
    @RequestMapping(value = "/hello?name=feign",method = RequestMethod.GET)
    public String sayHello();
}
