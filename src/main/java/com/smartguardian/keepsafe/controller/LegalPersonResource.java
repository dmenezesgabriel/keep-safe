package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.LegalPerson;
import com.smartguardian.keepsafe.repository.LegalPersonRepository;

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
@RequestMapping("legalperson")
public class LegalPersonResource {
    @Autowired
    private LegalPersonRepository legalPersonRepository;

    @GetMapping
    public List<LegalPerson> findAll() {
        return legalPersonRepository.findAll();
    }

    @GetMapping("{id}")
    public LegalPerson findById(@PathVariable int id) {
        return legalPersonRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public LegalPerson create(@RequestBody LegalPerson legalPerson) {
        return legalPersonRepository.save(legalPerson);
    }

    @PutMapping("{id}")
    public LegalPerson update(@RequestBody LegalPerson legalPerson, @PathVariable int id) {
        legalPerson.setId(id);
        return legalPersonRepository.save(legalPerson);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        legalPersonRepository.deleteById(id);
    }
}
