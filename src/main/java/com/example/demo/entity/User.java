package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_generator")
    @SequenceGenerator(name="user_id_generator", sequenceName = "user_id_generator")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
