package com.lofitskyi.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal rate;
}
