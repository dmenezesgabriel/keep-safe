package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
