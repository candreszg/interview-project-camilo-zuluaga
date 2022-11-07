package com.ninjaone.backendinterviewproject.model.dto;

public class DeviceDto {

    private String id;
    private String name;
    private String deviceTypeId;

    public DeviceDto() {
    }

    public DeviceDto(String id, String name, String deviceTypeId) {
        this.id = id;
        this.name = name;
        this.deviceTypeId = deviceTypeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }
}
