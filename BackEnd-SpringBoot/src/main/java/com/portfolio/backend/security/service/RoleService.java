package com.portfolio.backend.security.service;

import com.portfolio.backend.security.models.Role;
import com.portfolio.backend.security.enums.RoleName;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.security.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
    
    public void saveRole(Role role){
        roleRepository.save(role);
    }
}
