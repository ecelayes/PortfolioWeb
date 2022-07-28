package com.portfolio.backend.security.service;

import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.security.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository userRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return userRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByNombreUsuario(String nombreUsuario){
        return userRepo.existByNombreUsuario(nombreUsuario);
    }
    
    public void saveUsuario(Usuario usuario){
        userRepo.save(usuario);
    }
    
}
