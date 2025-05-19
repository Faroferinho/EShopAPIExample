package org.example.controllers;

import org.example.documents.DTOs.ProductDTO;
import org.example.documents.Product;
import org.example.safety.Constants;
import org.example.services.ProductService;
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
public class ProductController implements CRUDController<Product, ProductDTO>{
    //TODO - Adicionar verificação de Autenticação.

    @Autowired
    ProductService service;

    @Override
    @PostMapping(Constants.PRODUCT)
    public ResponseEntity<Product> create(ProductDTO productDTO) {
        Product newProduct = service.save(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @Override
    @GetMapping(Constants.PRODUCT)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping(Constants.PRODUCT + "/{id}")
    public ResponseEntity<Optional<Product>> findById(String id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @Override
    @DeleteMapping(Constants.PRODUCT + "/{id}")
    public ResponseEntity<Void> deleteById(String id) {
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
