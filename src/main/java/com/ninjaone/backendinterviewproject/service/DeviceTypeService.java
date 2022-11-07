package com.ninjaone.backendinterviewproject.service;

import com.ninjaone.backendinterviewproject.database.DeviceTypeRepository;
import com.ninjaone.backendinterviewproject.model.Devicetype;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceTypeService {

    private final DeviceTypeRepository deviceTypeRepository;

    public DeviceTypeService(DeviceTypeRepository deviceTypeRepository) {
        this.deviceTypeRepository = deviceTypeRepository;
    }


    public Devicetype getDeviceType(String deviceTypeId) {

        return deviceTypeRepository.findById(deviceTypeId).orElse(null);

    }

    public List<Devicetype> getDeviceTypes() {

        List<Devicetype> devicetypes = new ArrayList<>();

        deviceTypeRepository.findAll().forEach(devicetypes::add);
        return devicetypes;

    }
}
