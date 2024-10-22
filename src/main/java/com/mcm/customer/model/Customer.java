package com.mcm.customer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`Customer`")
public class Customer {

    @Id
    @Column(name = "`Id`", insertable = false, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "`Identification`", updatable = false, nullable = false, length = 20, unique = true)
    private String identification;

    @Column(name = "`Name`", nullable = false, length = 50)
    private String name;

    @Column(name = "`Lastname`", nullable = false, length = 50)
    private String lastname;

}
