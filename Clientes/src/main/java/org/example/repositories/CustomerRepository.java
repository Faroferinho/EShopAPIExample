package org.example.repositories;

import org.example.documents.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customers, String> {
}
