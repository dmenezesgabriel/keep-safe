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
import org.springframework.web.server.ResponseStatusException;

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
        try {
            LegalPerson legalPerson = legalPersonRepository.findById(id).get();
            return legalPerson;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Legal person not found", error);
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public LegalPerson create(@RequestBody LegalPerson legalPerson) {
        return legalPersonRepository.save(legalPerson);
    }

    @PutMapping("{id}")
    public LegalPerson update(@RequestBody LegalPerson legalPerson,
            @PathVariable int id) {
        LegalPerson user = legalPersonRepository.findById(id).get();
        legalPerson.setId(id);
        legalPerson.setCreatedAt(user.getCreatedAt());
        return legalPersonRepository.save(legalPerson);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        legalPersonRepository.deleteById(id);
    }
}
