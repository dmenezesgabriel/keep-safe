package com.smartguardian.keepsafe.repository;

import com.smartguardian.keepsafe.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer> {

}
