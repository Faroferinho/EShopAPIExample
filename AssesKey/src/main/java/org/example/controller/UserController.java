package org.example.controller;

import org.example.models.DataTransferObject.UserDTO;
import org.example.models.User;
import org.example.safety.Constant;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constant.USER)
public class UserController implements CRUDController<User, UserDTO {
    @Autowired
    private UserService service;

    @Override
    @PostMapping()
    public ResponseEntity<User> create(UserDTO userDTO) {
        User u = service.save(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(Long id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteByID(id);

        return ResponseEntity.noContent().build();
    }
}
