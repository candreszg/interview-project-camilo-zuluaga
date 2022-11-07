package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.ServiceByDeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.Service;
import com.ninjaone.backendinterviewproject.model.Servicebydevice;
import com.ninjaone.backendinterviewproject.model.dto.ServiceByDeviceDto;
import java.util.List;


@org.springframework.stereotype.Service
public class ServiceByDeviceService {

    private final ServiceByDeviceRepository serviceByDeviceRepository;
    private final ServiceService serviceService;
    private final DeviceService deviceService;

    public ServiceByDeviceService(ServiceByDeviceRepository serviceByDeviceRepository, ServiceService serviceService, DeviceService deviceService) {
        this.serviceByDeviceRepository = serviceByDeviceRepository;
        this.serviceService = serviceService;
        this.deviceService = deviceService;
    }

    public List<Servicebydevice> getServicesByDeviceList(String deviceId){

        List<Servicebydevice> sbdList = serviceByDeviceRepository.findByDeviceId(deviceId);

        return sbdList;
    }

    public Servicebydevice saveServiceByDeviceEntity(ServiceByDeviceDto sbdDto) {

        Servicebydevice entity = new Servicebydevice();

        Service service = serviceService.getServiceEntity(sbdDto.getServiceId());

        if(service == null){
            return null;
        }

        Device device = deviceService.getDeviceEntity(sbdDto.getDeviceId());

        if(device == null){
            return null;
        }

        String entityId = String.join("-",device.getId(),service.getId());

        if (serviceByDeviceRepository.findById(entityId).orElse(null) != null){
            return null;
        }

        entity.setService(service);
        entity.setDevice(device);
        entity.setId(entityId);

        return serviceByDeviceRepository.save(entity);
    }

    public void deleteServiceByDeviceEntity(String serviceByDeviceId){

       Servicebydevice entity = serviceByDeviceRepository.findById(serviceByDeviceId).orElse(null);

       if(entity == null){
           return;
       }

       serviceByDeviceRepository.delete(entity);

    }
}
