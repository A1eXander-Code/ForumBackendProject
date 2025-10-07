package com.forum.forum.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forum.forum.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUserId(Long userId);

    Optional<User> findByUserId(Long userId);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
