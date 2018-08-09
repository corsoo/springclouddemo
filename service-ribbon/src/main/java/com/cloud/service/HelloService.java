package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ZhangSong on 2018/8/7.
 */

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError") //指定fallbackMethod熔断方法
    public String hiService(String name) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello?name="+name,String.class);
    }

    public String hiError(String name){
        return name + "error";
    }

}