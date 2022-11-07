package com.ninjaone.backendinterviewproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Device {
    @Id
    private String id;
    private String customerid;
    private String name;

    @OneToMany(mappedBy = "device")
    private List<Servicebydevice> servicebydevices;

    @ManyToOne
    @JoinColumn(name="devicetypeId")
    private Devicetype devicetype;

    public Device() {

    }

    public Device(String id, String name, String customerid, Devicetype devicetype) {
        this.id = id;
        this.name = name;
        this.customerid = customerid;
        this.devicetype = devicetype;
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

    public Devicetype getDevicetype() {
        return devicetype;
    }
    public void setDevicetype(Devicetype devicetype) {
        this.devicetype = devicetype;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
}