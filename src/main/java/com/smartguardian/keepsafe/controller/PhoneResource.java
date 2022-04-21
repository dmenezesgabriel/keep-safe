package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.Phone;
import com.smartguardian.keepsafe.repository.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("phone")
public class PhoneResource {
    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @GetMapping("{id}")
    public Phone findById(@PathVariable int id) {
        try {
            Phone phone = phoneRepository.findById(id).get();
            return phone;
        } catch (Exception error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Phone not found", error);
        }
    }

    @GetMapping("/user")
    public List<Phone> findByUserId(@RequestParam int userId) {
        return phoneRepository.findByUserId(userId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Phone create(@RequestBody Phone phone) {
        return phoneRepository.save(phone);
    }

    @PutMapping("{id}")
    public Phone update(@RequestBody Phone phone, @PathVariable int id) {
        Phone requestedPhone = phoneRepository.findById(id).get();
        phone.setId(id);
        phone.setCreatedAt(requestedPhone.getCreatedAt());
        return phoneRepository.save(phone);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        phoneRepository.deleteById(id);
    }
}
