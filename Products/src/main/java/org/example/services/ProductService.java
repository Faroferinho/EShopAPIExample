package org.example.services;

import org.example.documents.DTOs.ProductDTO;
import org.example.documents.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CRUDServices<Product, ProductDTO> {
    @Autowired
    ProductRepository repository;

    @Override
    public Product save(ProductDTO productDTO) {
        Product p = new Product(productDTO);

        repository.save(p);

        return p;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findByID(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByID(String id) {
        repository.deleteById(id);
    }
}
