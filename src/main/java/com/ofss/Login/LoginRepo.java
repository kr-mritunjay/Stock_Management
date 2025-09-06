package com.ofss.Login;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginRequest, Long> {
    Optional<LoginRequest> findByUsername(String username);
}
