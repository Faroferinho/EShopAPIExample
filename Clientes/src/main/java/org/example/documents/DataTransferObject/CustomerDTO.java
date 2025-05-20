package org.example.documents.DataTransferObject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class CustomerDTO {
    private String name;
    private String phone;
    private Date registerDate;
}
