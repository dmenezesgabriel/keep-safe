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

@RestController
@RequestMapping("issue/status")
public class IssueStatusResource {
    @Autowired
    private IssueStatusRepository issuestatusRepository;

    @GetMapping
    public List<IssueStatus> findAll() {
        return issuestatusRepository.findAll();
    }

    @GetMapping("{id}")
    public IssueStatus findById(@PathVariable int id) {
        return issuestatusRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public IssueStatus create(@RequestBody IssueStatus issuestatus) {
        return issuestatusRepository.save(issuestatus);
    }

    @PutMapping("{id}")
    public IssueStatus update(@RequestBody IssueStatus issuestatus, @PathVariable int id) {
        issuestatus.setId(id);
        return issuestatusRepository.save(issuestatus);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        issuestatusRepository.deleteById(id);
    }
}
