package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueStatusRepository extends JpaRepository<IssueStatus, Integer> {

}
