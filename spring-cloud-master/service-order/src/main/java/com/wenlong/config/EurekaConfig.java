package com.wenlong.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 11:16 2018/10/19
 * @ Description：${description}
 * @ Modified By：
 */
@Configuration
public class EurekaConfig {

    /**
     * @LoadBalanced注解表明这个restRemplate开启负载均衡的功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
