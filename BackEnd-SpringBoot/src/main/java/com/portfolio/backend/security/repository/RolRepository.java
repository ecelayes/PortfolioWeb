package com.portfolio.backend.security.repository;

import com.portfolio.backend.security.entity.Rol;
import com.portfolio.backend.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
