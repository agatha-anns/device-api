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

    public List<Device> getAll(){//get all devices
        return repository.findAll();
    }
}
