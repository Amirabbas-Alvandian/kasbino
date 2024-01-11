package com.kasbino.bootcamp.repository;

import com.kasbino.bootcamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
