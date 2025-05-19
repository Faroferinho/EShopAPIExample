package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.example.documents.DTOs.ProductDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Getter @Setter
public class Product {
    private String id;
    private String name;
    private BigDecimal value;
    private Date registerDate;

    public Product() {

    }

    public Product(ProductDTO productDTO){
        name = productDTO.getName();
        value = productDTO.getValue();
        registerDate = productDTO.getRegisterDate();
    }
}
