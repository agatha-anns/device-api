package com.device.device_api;

import com.device.device_api.entity.Device;
import com.device.device_api.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DeviceServiceTest {


        @Autowired
        private DeviceService service;

        @Test
        void shouldCreateDevice() {
            Device d = new Device();
            d.setName("Pixel");
            d.setBrand("Google");
            d.setState("AVAILABLE");

            Device saved = service.save(d);

            assertNotNull(saved.getId());
            assertNotNull(saved.getCreationTime());
        }

        @Test
        void shouldNotDeleteInUseDevice(){
            Device d = new Device();
            d.setName("17 pro");
            d.setBrand("Apple");
            d.setState("IN-USE");
            Device saved = service.save(d);

            assertThrows(RuntimeException.class, () -> service.delete(saved.getId()));
        }

        @Test
        void shouldUpdateDevice() {
            Device d = new Device();
            d.setName("Old");
            d.setBrand("Apple");
            d.setState("NEW");

            Device saved = service.save(d);

            Device updated = new Device();
            updated.setName("New");
            updated.setBrand("Apple");
            updated.setState("IN-USE");
            Device result = service.update(saved.getId(), updated);

            assertEquals("New", result.getName());
            assertEquals("Apple", result.getBrand());
            assertEquals("IN-USE", result.getState());
        }

        @Test
        void shouldDeleteDevice() {
            Device d = new Device();
            d.setName("Test");
            d.setBrand("Samsung");
            d.setState("AVAILABLE");
            Device saved = service.save(d);

            assertDoesNotThrow(() -> service.delete(saved.getId()));
        }

        @Test
        void shouldThrowWhenDeviceNotFound() {
            assertThrows(RuntimeException.class, () -> service.getById(9999L));
        }

}
