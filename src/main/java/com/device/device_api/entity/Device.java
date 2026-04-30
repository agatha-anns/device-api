package com.device.device_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String state;

    @Column(updatable = false, nullable = false)//creation time is auto-set
    private LocalDateTime creationTime;

    @PrePersist
    void setCreationTime(){
        this.creationTime = LocalDateTime.now();
    }
}
