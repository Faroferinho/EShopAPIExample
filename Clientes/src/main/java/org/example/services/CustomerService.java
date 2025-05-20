package org.example.services;

import org.example.documents.Customers;
import org.example.documents.DataTransferObject.CustomerDTO;
import org.example.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements CRUDServices<Customers, CustomerDTO> {
    @Autowired
    CustomerRepository repository;

    @Override
    public Customers save(CustomerDTO customerDTO) {
        Customers newCustomer = repository.save(new Customers(customerDTO));
        return null;
    }

    @Override
    public List<Customers> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customers> findByID(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByID(String id) {
        repository.deleteById(id);
    }
}
