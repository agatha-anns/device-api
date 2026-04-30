package com.device.device_api.service;

import com.device.device_api.entity.Device;
import com.device.device_api.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public Device save(Device device){//save new device
        return repository.save(device);
    }

    public Device update(Long id, Device updated){
        Device device = getById(id);

        if("IN-USE".equalsIgnoreCase(device.getState())){
            throw new RuntimeException("Device in use,cannot be updated");
        }
        device.setName(updated.getName());
        device.setBrand(updated.getBrand());
        device.setState(updated.getState());

        return repository.save(device);
    }


    public Device getById(Long id){//get by id
        return repository.findById(id).orElseThrow( () -> new RuntimeException("Device not found"));
    }

    public List<Device> getAll(){//get all devices
        return repository.findAll();
    }

    public List<Device> getByBrand(String brand){//get devices from specific brand
        return repository.findByBrand(brand);
    }

    public List<Device> getByState(String state){// get devices in different states
        return repository.findByState(state);
    }

    public void delete(Long id){// prevent deleting device in use
        Device device = getById(id);

        if("IN-USE".equalsIgnoreCase(device.getState())){
            throw new RuntimeException("Device in use,cannot be deleted");
        }
        repository.deleteById(id);
    }


}
