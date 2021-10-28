package com.example.registryserver.registry;

import com.example.registryserver.info.InstanceInfo;

/**
 * @auther zgp
 * @desc 高可用环境
 * @date 2021/10/28
 */
public class PeerAwareInstanceRegistry extends InstanceRegistry{

    @Override
    public void registry(InstanceInfo instanceInfo) {
        super.registry(instanceInfo);
        // replicaToPeers(instanceInfo);
    }

    @Override
    public boolean renew(String appName, String instanceId) {
        if (super.renew(appName, instanceId)) {
            // replicaToPeers();
        }
        return false;
    }

    @Override
    public boolean cancel() {
        if (super.cancel()) {
            // replicaToPeers();
        }
        return false;
    }

    private void replicaToPeers(String appName, String instanceId) {
        // TODO 获取到其他 server 节点的 url

        // String result = restTemplate.postForObject("", null, String.class);
    }

    private void replicaToPeers(InstanceInfo instanceInfo) {
        // TODO 获取到其他 server 节点的 url

        // String result = restTemplate.postForObject("", instanceInfo, String.class);
    }
}
