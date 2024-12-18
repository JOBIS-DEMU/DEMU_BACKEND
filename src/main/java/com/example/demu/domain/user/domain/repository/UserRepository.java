package com.example.demu.domain.user.domain.repository;

import com.example.demu.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    User findUserByAccountId(String accountId);

    Optional<User> findByNickname(String nickname);

}
