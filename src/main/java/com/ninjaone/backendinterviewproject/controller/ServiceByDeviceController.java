package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Servicebydevice;
import com.ninjaone.backendinterviewproject.model.dto.ServiceByDeviceDto;
import com.ninjaone.backendinterviewproject.service.ServiceByDeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicebydevice")
public class ServiceByDeviceController {

public final ServiceByDeviceService serviceByDeviceService;

    public ServiceByDeviceController(ServiceByDeviceService serviceByDeviceService) {
        this.serviceByDeviceService = serviceByDeviceService;
    }

    @PostMapping
    public Servicebydevice saveServicesByDevice(@RequestBody ServiceByDeviceDto sbdDto){
        return serviceByDeviceService.saveServiceByDeviceEntity(sbdDto);
    }

    @DeleteMapping("/{id}")
    public void deleteServiceByDevice(@PathVariable String id){
        serviceByDeviceService.deleteServiceByDeviceEntity(id);
    }

}
