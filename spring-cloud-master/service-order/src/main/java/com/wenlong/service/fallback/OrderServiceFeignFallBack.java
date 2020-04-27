package com.wenlong.service.fallback;

import com.wenlong.service.OrderServiceFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：李文龙
 * @ Date       ：Created in 14:06 2018/10/31
 * @ Description：${description}
 * @ Modified By：
 */
@Component
public class OrderServiceFeignFallBack implements OrderServiceFeign {
    @Override
    public List<String> getMembers() {
        List<String> list = new ArrayList();
        list.add("Feign FallBack");
        return list;
    }
}
