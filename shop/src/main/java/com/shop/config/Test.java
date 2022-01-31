package com.shop.config;

import org.springframework.context.annotation.Bean;



public class Test {
    @Bean // @Bean을 설정할 경우 @Autowired 빈 호출 가능
    public String testStart() {
        return "test";
    }
}
