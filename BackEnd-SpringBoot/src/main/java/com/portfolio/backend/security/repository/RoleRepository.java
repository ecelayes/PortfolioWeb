package com.portfolio.backend.security.repository;

import com.portfolio.backend.security.enums.RoleName;
import com.portfolio.backend.security.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleName(RoleName roleName);
}
