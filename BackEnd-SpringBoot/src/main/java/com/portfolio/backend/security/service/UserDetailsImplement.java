package com.portfolio.backend.security.service;

import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplement implements UserDetailsService{
    
    @Autowired
    public UsuarioService userServ; 

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = userServ.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    } 
    
}
