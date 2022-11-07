package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.service.ServiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public Service saveService(@RequestBody Service service){
        return serviceService.saveServiceEntity(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable String id){
        serviceService.deleteServiceEntity(id);
    }

}
