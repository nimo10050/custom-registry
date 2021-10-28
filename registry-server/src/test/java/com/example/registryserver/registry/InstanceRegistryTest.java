package com.example.registryserver.registry;


import com.example.registryserver.info.InstanceInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther zgp
 * @desc
 * @date 2021/10/27
 */
public class InstanceRegistryTest {

    private int FIXED_THREAD_NUM = 3000;

    @Test
    public void testAddInstanceInfo() throws InterruptedException {

        InstanceRegistry registry = new InstanceRegistry();

        for (int i=0;i<FIXED_THREAD_NUM;i++) {
            // 获得1000个线程的线程池
            new Thread(()->{
                InstanceInfo instanceInfo = new InstanceInfo();
                instanceInfo.setAppName("app");
                instanceInfo.setInstanceId(UUID.randomUUID().toString() + System.currentTimeMillis());
                registry.registry(instanceInfo);

            }).start();

        }

        Thread.sleep(30000);
        System.out.println(registry.getRegistry().get("app").entrySet().size());
    }


}