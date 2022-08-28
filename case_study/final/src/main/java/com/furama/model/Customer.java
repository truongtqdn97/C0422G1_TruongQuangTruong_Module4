package com.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "DATE")
    private String birthday;

    private int gender;
    private String identifyCard;
    private  String phoneNumber;
    private  String email;

    @ManyToOne
    @JoinColumn(name = "customerType", referencedColumnName = "id")
    private CustomerType customerType;

    private String address;
}
