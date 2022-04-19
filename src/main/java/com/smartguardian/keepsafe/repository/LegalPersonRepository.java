package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Integer> {

}
