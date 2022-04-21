package com.smartguardian.keepsafe.repository;

import java.util.List;
import com.smartguardian.keepsafe.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
  List<Phone> findByUserId(int userId);
}
