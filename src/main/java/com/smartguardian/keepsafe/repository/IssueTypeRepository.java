package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueTypeRepository extends JpaRepository<IssueType, Integer> {

}
