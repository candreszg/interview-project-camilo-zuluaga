package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Servicebydevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceByDeviceRepository extends CrudRepository<Servicebydevice,String> {
    List<Servicebydevice> findByDeviceId(String deviceId);
}
