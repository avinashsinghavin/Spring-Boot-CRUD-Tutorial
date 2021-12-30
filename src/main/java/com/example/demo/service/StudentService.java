package com.example.demo.service;

import com.example.demo.entity.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> getAllStudent();
    StudentEntity getAllStudentById(Long id);
    StudentEntity addStudentDetails(StudentEntity se);
    StudentEntity updateStudentDetails(StudentEntity se);
    StudentEntity saveStudentDetails(StudentEntity se);
    StudentEntity getParticularStudent(String id);
    boolean deleteStudent(Long id);
}
