package com.example.dput.dput.controller;

import com.example.dput.dput.model.Protocol;
import com.example.dput.dput.repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
public class ProtocolController {

    @Autowired
    ProtocolRepository protocolRepo;



    @ResponseBody
    @GetMapping("/protocols")
    public ArrayList<Protocol> allProtocol()
    {
        ArrayList<Protocol> protocols = (ArrayList)protocolRepo.findAll();
        return protocols;
    }



    @PostMapping("/protocol")
    public void createProtocol(@RequestBody Protocol protocol) {

        protocolRepo.save(protocol);


    }


    @DeleteMapping("/protocol/{protocolId}")
    public void deleteProtocol(@PathVariable("protocolId") int protocolId) {


        protocolRepo.deleteById(protocolId);


    }
}
