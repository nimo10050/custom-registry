package com.example.registryserver.registry;

import com.example.registryserver.info.InstanceInfo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther zgp
 * @desc 本地注册表, 保存客户端注册信息
 * @date 2021/10/26
 */
public class InstanceRegistry {

    private ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceInfo>> registry = new ConcurrentHashMap<>();

    /**
     * 添加服务实例信息到本地注册表
     * @param instanceInfo
     */
    public void registry(InstanceInfo instanceInfo) {
        instanceInfo.setLastRenewTimestamp(System.currentTimeMillis());
        ConcurrentHashMap<String, InstanceInfo> gMap = registry.get(instanceInfo.getAppName());
        if (gMap == null) {
            gMap = new ConcurrentHashMap<>();
            registry.put(instanceInfo.getAppName(), gMap);
        }
        gMap.put(instanceInfo.getInstanceId(), instanceInfo);
    }

    public boolean renew(String appName, String instanceId) {
        ConcurrentHashMap<String, InstanceInfo> gMap = registry.get(appName);
        if (gMap == null) {
            return false;
        }

        InstanceInfo instanceInfo = gMap.get(instanceId);
        if (instanceInfo == null) {
            return false;
        }

        if ("UNKNOWN".equals(instanceInfo.getStatus())) {
            return false;
        }
        instanceInfo.setLastRenewTimestamp(System.currentTimeMillis());
        return true;
    }

    public boolean cancel() {
        return false;
    }

    public ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceInfo>> getRegistry() {
        return registry;
    }
}
