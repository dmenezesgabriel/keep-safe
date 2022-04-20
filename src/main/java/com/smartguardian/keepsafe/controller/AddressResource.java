package com.smartguardian.keepsafe.controller;

import java.util.List;

import com.smartguardian.keepsafe.model.Address;
import com.smartguardian.keepsafe.repository.AddressRepository;

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
@RequestMapping("address")
public class AddressResource {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @GetMapping("{id}")
    public Address findById(@PathVariable int id) {
        try {
            Address address = addressRepository.findById(id).get();
            return address;
        } catch (Error error) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Address not found", error);
        }
    }

    @GetMapping("/user")
    public List<Address> findByUserId(@RequestParam int userId) {
        return addressRepository.findByUserId(userId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Address create(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @PutMapping("{id}")
    public Address update(@RequestBody Address address, @PathVariable int id) {
        Address requestedAddress = addressRepository.findById(id).get();
        address.setId(id);
        address.setCreatedAt(requestedAddress.getCreatedAt());
        return addressRepository.save(address);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        addressRepository.deleteById(id);
    }
}
