package org.example.documents.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class ProductDTO {
    private String name;
    private BigDecimal value;
    private Date registerDate;
}
