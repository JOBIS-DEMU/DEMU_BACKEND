package com.example.demu.domain.user.domain.repository;

import com.example.demu.domain.user.domain.Usexr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usexr, Long> {
    Optional<Usexr> findByAccountId(String accountId);
}
