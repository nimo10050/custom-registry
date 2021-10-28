package com.example.registryserver.controller;

import com.example.registryserver.info.InstanceInfo;
import com.example.registryserver.registry.InstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther zgp
 * @desc
 * @date 2021/10/26
 */
@RestController
@RequestMapping("/server")
public class AppController {

    @Autowired
    private InstanceRegistry registry;

    @PostMapping("/registry")
    public String registry(@RequestBody InstanceInfo instanceInfo) {
        // TODO 参数校验
        // 注册到本地表
        registry.registry(instanceInfo);
        return "success";
    }

    @GetMapping("/fetch")
    public String fetch() {

        return "success";
    }

    @PutMapping("/renew")
    public String renew(String appName, String instanceId) {
        registry.renew(appName, instanceId);
        return "success";
    }

    @DeleteMapping("cancel")
    public String cancel() {
        return "success";
    }


}
