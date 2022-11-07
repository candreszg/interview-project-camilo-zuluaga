package com.ninjaone.backendinterviewproject.database;

import com.ninjaone.backendinterviewproject.model.Devicetype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTypeRepository extends CrudRepository<Devicetype,String> {
}
