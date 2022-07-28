package com.portfolio.backend.security.repository;

import com.portfolio.backend.security.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUserName(String userName);
    
    boolean existsByUserName(String userName);

}
