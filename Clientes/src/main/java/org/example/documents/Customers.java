package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.example.documents.DataTransferObject.CustomerDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter @Setter
public class Customers {
    private String id;
    private String name;
    private String phone;
    private Date registerDate;

    public Customers(){

    }

    public Customers(CustomerDTO dto){
        name = dto.getName();
        phone = dto.getPhone();
        registerDate = dto.getRegisterDate();
    }

}
