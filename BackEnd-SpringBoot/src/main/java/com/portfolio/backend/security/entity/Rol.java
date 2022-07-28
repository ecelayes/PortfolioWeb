package com.portfolio.backend.security.entity;

import com.portfolio.backend.security.enums.RolNombre;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
    
    //Constructores

    public Rol() {
    }

    public Rol(Long id, RolNombre rolNombre) {
        this.id = id;
        this.rolNombre = rolNombre;
    }
    
    //Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

}
