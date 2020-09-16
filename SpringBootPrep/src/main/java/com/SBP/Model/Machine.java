package com.SBP.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Component("Machine")
@Entity
@Table(name = "machine")
public class Machine implements Serializable {
    public static final long serialVersionUUID = 10L;

   @Getter @Setter
   @Id
   @Column(name = "machine_id")
   public String machineId;
    @Getter @Setter
    @Column(name = "serial_number")
    public String serialNumber;
    @Getter @Setter
    @Column(name = "software_image")
    public String softwareImage;
    @Getter @Setter
    @Column(name = "model_name")
    public String modelName;
    @Getter @Setter
    @Column(name = "machine_status")
    public String machineStatus;


}
