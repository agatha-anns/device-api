package com.device.device_api.controller;

import com.device.device_api.entity.Device;
import com.device.device_api.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PutMapping("/{id}")
    public Device update(@PathVariable Long id, @RequestBody Device device){//update existing device
        try {
            return service.update(id, device);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Device getById(@PathVariable Long id){//fetch a single device
        try {
            return service.getById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Device not found");
        }
    }

    @GetMapping
    public List<Device> getAll(){// gett all devices
        return service.getAll();
    }

    @GetMapping("/brand/{brand}")
    public List<Device> getByBrand(@PathVariable String brand){//fetch devices by brand
        return service.getByBrand(brand);
    }

    @GetMapping("/state/{state}")
    public List<Device> getByState(@PathVariable String state){//fetch devices by state
        return service.getByState(state);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){//delete device
        try {
            service.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
