package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Integer> {

}
