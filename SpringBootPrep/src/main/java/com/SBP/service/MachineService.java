package com.SBP.service;

import com.SBP.DAO.MachineManager;
import com.SBP.Model.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MachineService")
public class MachineService {

    @Autowired
    MachineManager mDAO;

    public boolean insertMachine(Machine machine){
        mDAO.setup();
        boolean flag = mDAO.insertMachine(machine);
        mDAO.exit();
        return flag;
    }

    public List getMachines(){
        return mDAO.getAllMachines();
    }

}
