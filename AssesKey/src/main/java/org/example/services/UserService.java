package org.example.services;


import jakarta.validation.constraints.NotNull;
import org.example.models.DataTransferObject.UserDTO;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements CRUDServices<User, UserDTO> {
    @Autowired
    private UserRepository repository;

    @Override
    public User save(UserDTO dto) {
        return repository.save(new User(dto));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findByID(long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByID(long id) {
        repository.deleteById(id);
    }

    public boolean validadeLogin(@NotNull User u){
        if(repository.findById(u.getId()).isPresent()){
            User userInDB = repository.findById(u.getId()).get();
            return Objects.equals(userInDB.getPassword(), u.getPassword());
        }

        return false;
    }
}
