package com.example.registryserver.discovery;

import com.example.registryserver.info.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @auther zgp
 * @desc 服务发现客户端
 * @date 2021/10/28
 */
@Component
public class DiscoveryClient {

    public HashMap<String, HashMap<String, InstanceInfo>> registry = new HashMap<>();

    @Autowired
    private RestTemplate restTemplate;

    private ScheduledExecutorService scheduler;

    @PostConstruct
    public void init() {
        // 拉取全量注册信息
        getAndStoreFullRegistry();

        scheduler = Executors.newScheduledThreadPool(2);

        // 心跳检测
        scheduler.schedule(()->{
            renew();
        }, 30, TimeUnit.SECONDS);
    }

    private void getAndStoreFullRegistry() {
        // TODO 通过某种策略从可用 url 列表中选择一个
        String url = "localhost:8080/server/fetch";
        registry = restTemplate.getForObject(url, HashMap.class);
    }

    // TODO renew
    private void renew() {
        restTemplate.postForObject("localhost:8080/server/heartbeat", null, String.class);
    }

    public HashMap<String, HashMap<String, InstanceInfo>> getRegistry() {
        return registry;
    }

}
