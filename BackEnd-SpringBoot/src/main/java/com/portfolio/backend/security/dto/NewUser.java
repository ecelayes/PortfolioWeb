package com.portfolio.backend.security.dto;

import java.util.HashSet;
import java.util.Set;

public class NewUser {
    
    private String userName;;
    private String password;
    private Set<String> roles = new HashSet<>();
    
    //Getter & Setter

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
