package com.example.volunteer.entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "students")
public class Student {

    @Id
    private int studentId;
    private String studentName;

}
