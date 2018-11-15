package com.example.dput.dput.controller;

import com.example.dput.dput.model.Device;

import com.example.dput.dput.repository.DeviceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepo;


    @GetMapping("/devices")
    public ArrayList<Device> allDevice() {
        ArrayList<Device> devices = (ArrayList) deviceRepo.findAll();
        return devices;
    }

    @PostMapping("/device")
    public ArrayList<Device> createDevice(@RequestBody Device device) {
        deviceRepo.save(device);
        ArrayList<Device> devices = (ArrayList) deviceRepo.findAll();
        return devices;
    }

}
