package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.dto.CostOfServiceDto;

import java.util.List;

@org.springframework.stereotype.Service
public class CostOfServiceService {

    private final ServiceService serviceService;
    private final DeviceService deviceService;
    private final Double DEVICE_BASE_COST = 4.00;

    public CostOfServiceService(ServiceService serviceService, DeviceService deviceService) {
        this.serviceService = serviceService;
        this.deviceService = deviceService;
    }

    public CostOfServiceDto getCostOfServiceByDevice(String deviceId) {

        if(deviceService.getDeviceEntity(deviceId) == null){
            return null;
        }

        CostOfServiceDto costOfServiceDto = new CostOfServiceDto();

        List<Service> servicesList = serviceService.getServicesByDeviceList(deviceId);

        Double totalCost = servicesList.stream().mapToDouble(s->s.getPrice()).sum() + DEVICE_BASE_COST;

        costOfServiceDto.setTotalCost(totalCost);

        return costOfServiceDto;
    }

    public CostOfServiceDto getCostOfServiceByCustomer(String customerId) {

        List<Device> devices = deviceService.getDevicesByCustomer(customerId);

        if(devices.size() == 0){
            return null;
        }

        CostOfServiceDto costOfServiceDto = new CostOfServiceDto();

        List<Service> servicesList = serviceService.getServicesByCustomerList(customerId);

        Double totalCost = servicesList.stream().mapToDouble(s->s.getPrice()).sum() + DEVICE_BASE_COST*devices.size();

        costOfServiceDto.setTotalCost(totalCost);

        return costOfServiceDto;
    }

}
