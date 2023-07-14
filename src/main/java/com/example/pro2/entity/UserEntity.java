package com.example.pro2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user", indexes = {@Index(name = "uk_email", columnList = "email", unique = true)})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(20) comment '姓名'")
    private String name;

    @Transient
    private int age;

    @Column(nullable = false, length = 50)
    private String email;

    private LocalDate birthday;
}
