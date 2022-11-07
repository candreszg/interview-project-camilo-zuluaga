package com.ninjaone.backendinterviewproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Servicebydevice {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "deviceId")
    private Device device;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;


    public Servicebydevice() {
    }

    public Servicebydevice(String id, Device device, Service service, Date subscriptionDate) {
        this.id = id;
        this.device = device;
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }
    public void setDevice(Device device) {
        this.device = device;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
