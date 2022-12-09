package com.example.volunteer.entity;


import com.example.volunteer.enums.Status;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;
    private Status status;

}
