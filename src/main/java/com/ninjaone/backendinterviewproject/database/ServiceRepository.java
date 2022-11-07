package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends CrudRepository<Service, String>{

    List<Service> findByServicebydevices_DeviceId(String deviceId);

    List<Service> findByServicebydevices_Device_customerid(String deviceId);

}
