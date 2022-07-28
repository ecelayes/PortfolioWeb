package com.portfolio.backend.security.repository;

import com.portfolio.backend.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existByNombreUsuario(String nombreUsuario);
}
