package com.SBP.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Component("Tenant")
@Entity
public class Tenant {
    @Getter
    @Setter
    @Id
    public String tenant_id;
    @Getter @Setter
    @Column
    public String tenant_name;
    @Getter @Setter
    @Column
    public String tenant_username;
    @Getter @Setter
    @Column
    public String tenant_password;
    @Getter @Setter
    @Column
    public boolean is_esp;
    @Getter @Setter
    @Column
    public String esp_tenant_id;
    @Getter @Setter
    @Column
    public String tenant_region;

}
