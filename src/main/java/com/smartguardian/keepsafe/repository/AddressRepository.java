package com.smartguardian.keepsafe.repository;

import java.util.List;
import com.smartguardian.keepsafe.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
  List<Address> findByUserId(int userId);
}
