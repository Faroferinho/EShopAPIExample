package org.example.controller;

import org.example.models.DataTransferObject.UserDTO;
import org.example.models.User;
import org.example.safety.Constant;
import org.example.safety.JwtTokenProvider;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Constant.USER)
public class UserController implements CRUDController<User, UserDTO> {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

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
    public ResponseEntity<List<User>> findAll(@RequestHeader(value = "Authorization") String token) {
        if(jwtTokenProvider.validateToken(token.substring(7))){
            return ResponseEntity.ok(service.findAll());
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@RequestHeader(value = "Authorization") String token, Long id) {
        if(jwtTokenProvider.validateToken(token.substring(7))){
            return ResponseEntity.ok(service.findByID(id));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@RequestHeader(value = "Authorization") String token, Long id) {
        if (jwtTokenProvider.validateToken(token.substring(7))) {
            service.deleteByID(id);

            return ResponseEntity.noContent().build();
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthenticated User");
    }
}
