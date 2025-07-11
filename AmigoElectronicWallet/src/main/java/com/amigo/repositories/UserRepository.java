package com.amigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
    Optional<User> findByMobile(String mobile);
}

