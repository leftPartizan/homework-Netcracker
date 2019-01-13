package com.crud.api;

import com.crud.model.Customer;
import com.crud.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerRepository repo;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List getAll() {
        System.out.println("S");
        return repo.getAll();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getById(@PathVariable("id") int id) {
        return repo.getById(id);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Customer customer) {
        return repo.create(customer);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAll() {
        return repo.deleteAll();
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteById(@PathVariable("id") int id) {
        return repo.deleteById(id);
    }
}
