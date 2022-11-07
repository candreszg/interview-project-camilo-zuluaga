package com.ninjaone.backendinterviewproject.controller;

import com.ninjaone.backendinterviewproject.model.Device;
import com.ninjaone.backendinterviewproject.model.dto.DeviceDto;
import com.ninjaone.backendinterviewproject.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {

private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Device postDeviceEntity(@RequestBody DeviceDto device) {
        return deviceService.saveDeviceEntity(device);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void updateDeviceEntity(@RequestBody DeviceDto device) {
        deviceService.updateDeviceEntity(device);
    }

    @GetMapping("/{id}")
    private Device getDeviceEntity(@PathVariable String id){
        return deviceService.getDeviceEntity(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteDeviceEntity(@PathVariable String id) {
        deviceService.deleteDeviceEntity(id);
    }

}
