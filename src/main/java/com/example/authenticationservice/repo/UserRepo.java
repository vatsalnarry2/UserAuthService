package com.example.authenticationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authenticationservice.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
