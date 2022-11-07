package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.dto.CostOfServiceDto;
import com.ninjaone.backendinterviewproject.service.CostOfServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costofservice")
public class CostOfServiceConstroller {

    private final CostOfServiceService costOfServiceService;

    public CostOfServiceConstroller(CostOfServiceService costOfServiceService) {
        this.costOfServiceService = costOfServiceService;
    }

    @GetMapping("device/{id}")
    public CostOfServiceDto getCostOfServiceByDevice(@PathVariable String id){
    return costOfServiceService.getCostOfServiceByDevice(id);
    }

    @GetMapping("customer/{id}")
    public CostOfServiceDto getCostOfServiceByCustomer(@PathVariable String id){
        return costOfServiceService.getCostOfServiceByCustomer(id);
    }

}
