package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceRepository;
import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.Devicetype;
import com.ninjaone.backendinterviewproject.model.dto.DeviceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceTypeService deviceTypeService;

    public DeviceService(DeviceRepository deviceRepository, DeviceTypeService deviceTypeService) {
        this.deviceRepository = deviceRepository;
        this.deviceTypeService = deviceTypeService;
    }

    public Device saveDeviceEntity(DeviceDto device){

        Device entity = new Device();

        //Check if the device exist in the DB
        if(deviceRepository.findById(device.getId()).orElse(null) != null){
            return null;
        }

        //Check if the deviceType is not null and exist
        if(device.getDeviceTypeId() == null){
            return null;
        }

        Devicetype deviceType = deviceTypeService.getDeviceType(device.getDeviceTypeId());

        if (deviceType == null){
            return null;
        }

        //Populate entity to save
        entity.setName(device.getName());
        entity.setId(device.getId());
        entity.setDevicetype(deviceType);

        return deviceRepository.save(entity);
    }

    public Device getDeviceEntity(String id){
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Device> getDevicesByCustomer(String customerId){
        return deviceRepository.findByCustomerid(customerId);
    }

    public void deleteDeviceEntity(String id){
        Device entity = deviceRepository.findById(id).orElse(null);

        if(entity == null){
            return;
        }
        deviceRepository.deleteById(id);
    }

    public void updateDeviceEntity(DeviceDto device) {

        //Check if device exist
        Device entity = deviceRepository.findById(device.getId()).orElse(null);
        if (entity == null) {
            return;
        }
        //Check if the device type is not null and exist
        if (device.getDeviceTypeId() == null) {
            return;
        }

        Devicetype deviceType = deviceTypeService.getDeviceType(device.getDeviceTypeId());

        if (deviceType == null){
            return;
        }

        //update properties
        entity.setDevicetype(deviceType);
        entity.setName(device.getName());

        deviceRepository.save(entity);
    }

    }

