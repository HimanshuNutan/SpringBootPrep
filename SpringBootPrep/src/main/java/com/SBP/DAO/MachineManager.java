package com.SBP.DAO;

import com.SBP.Model.Machine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class MachineManager {
    public SessionFactory sessionFactory;
    public void setup(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        }catch (Exception e){
            System.out.println(e);
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void exit(){
        sessionFactory.close();
    }
    public Machine getMachine(String machineId){
        Machine machine = new Machine();
        Session session = sessionFactory.openSession();
        try{
            machine =   session.get(Machine.class,machineId);

        }catch (Exception e){
            System.out.println(e);
        }
        return machine;
    }

    public boolean insertMachine(Machine machine){
        Session session = sessionFactory.openSession();
        Machine m1=null;
        boolean retVal;
        try {
            session.beginTransaction();
            session.save(machine);
            session.getTransaction().commit();
            m1=getMachine(machine.getMachineId());
            System.out.println(m1.getMachineId());
        }catch (Exception e){
            System.out.println(e);
        }
       return m1==null?false:true;
    }

    public List getAllMachines(){
        Session session = sessionFactory.openSession();
        List<Machine> list = new ArrayList<>();
        try{
            Query query = session.createQuery("from machine");
            System.out.println(query);
            list = query.list();
            System.out.println(list);
        }catch (Exception e){
            System.out.println(e);
        }
        return list;
    }




}
