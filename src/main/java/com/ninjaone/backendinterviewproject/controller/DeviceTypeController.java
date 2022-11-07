package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Devicetype;
import com.ninjaone.backendinterviewproject.service.DeviceTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devicetype")
public class DeviceTypeController {

    private final DeviceTypeService deviceTypeService;

    public DeviceTypeController(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    //add serviceType
    @GetMapping
    public List<Devicetype> getDeviceTypes(){
        return deviceTypeService.getDeviceTypes();
    }

    //Delete serviceType


}
