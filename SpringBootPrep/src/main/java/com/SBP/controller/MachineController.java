package com.SBP.controller;

import com.SBP.Model.Machine;
import com.SBP.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/machines")
public class MachineController {
    @Autowired
    MachineService machineService;

    @RequestMapping
    public String index() {
        return "Spring Boot Welcomes You!";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public boolean insertMachine(@RequestBody Machine machine)
    {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/insert").buildAndExpand(machine).toUri();
        System.out.println(location);
        return machineService.insertMachine(machine);
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List getMachines()
    {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        System.out.println(location);
       return machineService.getMachines();
    }
}
