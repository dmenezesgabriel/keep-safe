package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.IssueStatus;
import com.smartguardian.keepsafe.repository.IssueStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("issue/status")
public class IssueStatusResource {
    @Autowired
    private IssueStatusRepository issueStatusRepository;

    @GetMapping
    public List<IssueStatus> findAll() {
        return issueStatusRepository.findAll();
    }

    @GetMapping("{id}")
    public IssueStatus findById(@PathVariable int id) {
        try {
            IssueStatus issueStatus = issueStatusRepository.findById(id).get();
            return issueStatus;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Issue Status not found", error);
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public IssueStatus create(@RequestBody IssueStatus issueStatus) {
        return issueStatusRepository.save(issueStatus);
    }

    @PutMapping("{id}")
    public IssueStatus update(@RequestBody IssueStatus issueStatus,
            @PathVariable int id) {
        IssueStatus requestedIssueStatus =
                issueStatusRepository.findById(id).get();
        issueStatus.setId(id);
        issueStatus.setCreatedAt(requestedIssueStatus.getCreatedAt());
        return issueStatusRepository.save(issueStatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        issueStatusRepository.deleteById(id);
    }
}
