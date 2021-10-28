package com.example.registryserver.info;

import lombok.Data;

@Data
public class InstanceInfo {

	private String appName;
    
    private String instanceId;
    
    private String ip;
    
    private int port;
    
    private int status;

    private long lastRenewTimestamp;

}