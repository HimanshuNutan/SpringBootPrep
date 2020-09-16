
package com.SBP;
import com.SBP.DAO.MachineManager;
import com.SBP.Model.Machine;
import com.SBP.controller.MachineController;
import com.SBP.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;

@SpringBootApplication
public class SpringBootPrep{


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootPrep.class,args);
        System.out.println("This is a Spring Boot app");
//        Machine machine = new Machine();
//        machine.setMachineId("machine_144");
//        machine.setMachineStatus("Created");
//        machine.setModelName("ion25000");
//        machine.setSerialNumber("machine_144");
//        machine.setSoftwareImage("linux 13.1.1");
//        MachineController controller = new MachineController();
//        controller.insertMachine(machine);
        MachineManager manager = new MachineManager();
//        System.out.println(manager.getAllMachines());
        manager.setup();
        System.out.println(manager.getMachine("machine_143").getMachineId());
        manager.exit();
    }

}