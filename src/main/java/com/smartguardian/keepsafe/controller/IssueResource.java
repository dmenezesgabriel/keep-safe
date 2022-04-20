package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.Issue;
import com.smartguardian.keepsafe.repository.IssueRepository;

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
@RequestMapping("issue")
public class IssueResource {
    @Autowired
    private IssueRepository issueRepository;

    @GetMapping
    public List<Issue> findAll() {
        return issueRepository.findAll();
    }

    @GetMapping("{id}")
    public Issue findById(@PathVariable int id) {
        try {
            Issue issue = issueRepository.findById(id).get();
            return issue;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Issue not found", error);
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Issue create(@RequestBody Issue issue) {
        return issueRepository.save(issue);
    }

    @PutMapping("{id}")
    public Issue update(@RequestBody Issue issue, @PathVariable int id) {
        issue.setId(id);
        return issueRepository.save(issue);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        issueRepository.deleteById(id);
    }
}
