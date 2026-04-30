package com.device.device_api.controller;

import com.device.device_api.entity.Device;
import com.device.device_api.service.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {
    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @PostMapping
    public Device create(@RequestBody Device device){//create new device
        return service.save(device);
    }

    @GetMapping
    public List<Device> getAll(){// gett all devices
        return service.getAll();
    }
}
