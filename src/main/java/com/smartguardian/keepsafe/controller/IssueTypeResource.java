package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.IssueType;
import com.smartguardian.keepsafe.repository.IssueTypeRepository;

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
@RequestMapping("issue/type")
public class IssueTypeResource {
    @Autowired
    private IssueTypeRepository issueTypeRepository;

    @GetMapping
    public List<IssueType> findAll() {
        return issueTypeRepository.findAll();
    }

    @GetMapping("{id}")
    public IssueType findById(@PathVariable int id) {
        return issueTypeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public IssueType create(@RequestBody IssueType issueType) {
        return issueTypeRepository.save(issueType);
    }

    @PutMapping("{id}")
    public IssueType update(@RequestBody IssueType issueType, @PathVariable int id) {
        issueType.setId(id);
        return issueTypeRepository.save(issueType);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        issueTypeRepository.deleteById(id);
    }
}
