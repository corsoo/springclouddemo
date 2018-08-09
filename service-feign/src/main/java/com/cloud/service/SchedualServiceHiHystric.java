package com.cloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by ZhangSong on 2018/8/8.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return name + " error";
    }
}
