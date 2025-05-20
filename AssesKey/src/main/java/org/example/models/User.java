package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.example.models.DataTransferObject.UserDTO;

@Data
@Getter @Setter
public class User {
    @Id
    private Long email;
    private String password;

    public User(){

    }

    public User(UserDTO dto){
        email = dto.getEmail();
        password = dto.getPassword();
    }
}
