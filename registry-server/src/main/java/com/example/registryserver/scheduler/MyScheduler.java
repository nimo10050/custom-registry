package com.example.registryserver.scheduler;

import com.example.registryserver.info.InstanceInfo;
import com.example.registryserver.registry.InstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class MyScheduler {

    @Autowired
    private InstanceRegistry registry;

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void heartBeat(){
        // TODO 定时向客户端发送心跳检测
        ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceInfo>> registry = this.registry.getRegistry();
        Collection<ConcurrentHashMap<String, InstanceInfo>> values = registry.values();
        // values.parallelStream().collect()
        for (int i = 0; i < values.size(); i++) {

        }
        Set<Map.Entry<String, ConcurrentHashMap<String, InstanceInfo>>> entries = registry.entrySet();

        // List<InstanceInfo> instanceInfoList = entries.parallelStream()
    }


    @Scheduled(fixedDelay = 90, timeUnit = TimeUnit.SECONDS)
    public void evict(){
        // TODO 服务剔除
    }
}