package com.ninjaone.backendinterviewproject.service;


import com.ninjaone.backendinterviewproject.database.ServiceRepository;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.Servicebydevice;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service saveServiceEntity(Service service) {

        Service entity = new Service();

        //Check if the device exist in the DB
        if(serviceRepository.findById(service.getId()).orElse(null) != null){
            return null;
        }

        //Populate entity to save
        entity.setName(service.getName());
        entity.setId(service.getId());
        entity.setPrice(service.getPrice());

        return serviceRepository.save(entity);

    }

    public void deleteServiceEntity(String id) {

        Service entity = serviceRepository.findById(id).orElse(null);
        if(entity == null){
            return;
        }
        serviceRepository.delete(entity);

    }

    public Service getServiceEntity(String serviceId) {

        return serviceRepository.findById(serviceId).orElse(null);

    }

    public List<Service> getServicesByDeviceList(String deviceId) {

        List<Service> servicesByDevice = serviceRepository.findByServicebydevices_DeviceId(deviceId);

        return servicesByDevice;
    }

    public List<Service> getServicesByCustomerList(String customerId) {

        List<Service> servicesByCustomer = serviceRepository.findByServicebydevices_Device_customerid(customerId);

        return servicesByCustomer;
    }
}
