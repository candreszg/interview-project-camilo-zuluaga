package com.ninjaone.backendinterviewproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Devicetype {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "devicetype")
    private List<Device> devices;

    public Devicetype() {
    }

    public Devicetype(String id, String name) {
        this.id = id;
        this.name = name;
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

}