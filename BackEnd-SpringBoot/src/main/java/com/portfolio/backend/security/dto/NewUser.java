package com.portfolio.backend.security.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewUser {
    
    private String userName;;
    private String password;
    private Set<String> roles = new HashSet<>();
    
}
