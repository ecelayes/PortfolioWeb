package com.portfolio.backend.security.service;

import com.portfolio.backend.security.entity.Rol;
import com.portfolio.backend.security.enums.RolNombre;
import com.portfolio.backend.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
   
    @Autowired
    public RolRepository rolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepo.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol){
        rolRepo.save(rol);
    }
}
