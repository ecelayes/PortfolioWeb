package com.portfolio.backend.security.entity;

import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
               joinColumns = @JoinColumn(name="usuario_id"),
               inverseJoinColumns = @JoinColumn(name="rol_id"))
    private Set<Rol> roles = new HashSet<>();

    //Constructores

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    //Getter & Setter

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
}
