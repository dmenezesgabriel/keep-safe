package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.NaturalPerson;
import com.smartguardian.keepsafe.repository.NaturalPersonRepository;

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
@RequestMapping("naturalperson")
public class NaturalPersonResource {
    @Autowired
    private NaturalPersonRepository naturalPersonRepository;

    @GetMapping
    public List<NaturalPerson> findAll() {
        return naturalPersonRepository.findAll();
    }

    @GetMapping("{id}")
    public NaturalPerson findById(@PathVariable int id) {
        try {
            NaturalPerson naturalPerson =
                    naturalPersonRepository.findById(id).get();
            return naturalPerson;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Natural person not found", error);
        }
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public NaturalPerson create(@RequestBody NaturalPerson naturalPerson) {
        return naturalPersonRepository.save(naturalPerson);
    }

    @PutMapping("{id}")
    public NaturalPerson update(@RequestBody NaturalPerson naturalPerson,
            @PathVariable int id) {
        NaturalPerson user = naturalPersonRepository.findById(id).get();
        naturalPerson.setId(id);
        naturalPerson.setCreatedAt(user.getCreatedAt());
        return naturalPersonRepository.save(naturalPerson);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        naturalPersonRepository.deleteById(id);
    }
}
