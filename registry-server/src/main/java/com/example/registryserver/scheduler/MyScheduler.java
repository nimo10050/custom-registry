package com.example.registryserver.scheduler;

import com.example.registryserver.registry.InstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class MyScheduler {

    @Autowired
    private InstanceRegistry registry;

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void heartBeat(){
        // TODO 定时向客户端发送心跳检测
    }


    @Scheduled(fixedDelay = 90, timeUnit = TimeUnit.SECONDS)
    public void evict(){
        // TODO 服务剔除
    }
}