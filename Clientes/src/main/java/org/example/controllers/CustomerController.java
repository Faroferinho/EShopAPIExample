package org.example.controllers;

import org.example.documents.Customers;
import org.example.documents.DataTransferObject.CustomerDTO;
import org.example.safety.Constants;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController implements CRUDController<Customers, CustomerDTO> {
    @Autowired
    private CustomerService service;

    @Override
    @PostMapping(Constants.CUSTOMER)
    public ResponseEntity<Customers> create(CustomerDTO dto) {
        Customers newCustomer = service.save(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }

    @Override
    @GetMapping(Constants.CUSTOMER)
    public ResponseEntity<List<Customers>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping(Constants.CUSTOMER + "/{id}")
    public ResponseEntity<Optional<Customers>> findById(String id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @Override
    @DeleteMapping(Constants.CUSTOMER + "/{id}")
    public ResponseEntity<Void> deleteById(String id) {
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
