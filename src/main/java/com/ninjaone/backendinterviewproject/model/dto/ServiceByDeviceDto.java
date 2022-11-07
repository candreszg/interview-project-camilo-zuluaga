package com.ninjaone.backendinterviewproject.model.dto;

import java.util.Date;

public class ServiceByDeviceDto {

    private String serviceId;
    private String deviceId;

    public ServiceByDeviceDto() {
    }

    public ServiceByDeviceDto(String serviceId, String deviceId) {
        this.serviceId = serviceId;
        this.deviceId = deviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

}
