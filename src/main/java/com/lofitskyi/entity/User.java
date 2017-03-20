package com.lofitskyi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class User implements Serializable{

    @Id
    @GeneratedValue
    @NonNull private Long id;
    @NonNull private String username;

    @ElementCollection
    private List<BigDecimal> wastes = new LinkedList<>();
}
