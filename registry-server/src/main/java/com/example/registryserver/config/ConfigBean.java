package com.example.registryserver.config;

import com.example.registryserver.registry.InstanceRegistry;
import com.example.registryserver.registry.PeerAwareInstanceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zgp
 * @desc
 * @date 2021/10/26
 */
@Configuration
public class ConfigBean {

    @Bean
    public InstanceRegistry instanceRegistry() {
        return new PeerAwareInstanceRegistry();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
