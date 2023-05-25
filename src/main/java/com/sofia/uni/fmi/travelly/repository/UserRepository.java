package com.sofia.uni.fmi.travelly.repository;

import com.sofia.uni.fmi.travelly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
