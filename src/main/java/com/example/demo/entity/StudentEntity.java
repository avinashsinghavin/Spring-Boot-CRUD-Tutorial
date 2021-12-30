package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "studententity")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long roll;
    private String name;
    private String class_name;
    private String teacher_name;
    private String teacher_id;
    private String subject;
}