package org.example.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.example.models.DataTransferObject.UserDTO;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public User(){

    }

    public User(UserDTO dto){
        email = dto.getEmail();
        password = dto.getPassword();
    }
}
