package com.security.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.boot.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByName(String username);
}