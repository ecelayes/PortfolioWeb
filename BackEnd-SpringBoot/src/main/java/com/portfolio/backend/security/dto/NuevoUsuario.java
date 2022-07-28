package com.portfolio.backend.security.dto;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    private String nombreUsuario;
    private String password;
    private Set<String> roles = new HashSet<>();
    
    //Getter & Setter

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
