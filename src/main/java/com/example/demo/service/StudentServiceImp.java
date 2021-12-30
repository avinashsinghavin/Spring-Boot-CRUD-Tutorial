package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepo.getAllRecords();
    }

    @Override
    public StudentEntity getAllStudentById(Long id) {
        Optional<StudentEntity> s = studentRepo.findById(id);
        System.out.println(s);
        if(s.isPresent())
            return s.get();
        return null;
    }

    @Override
    public StudentEntity addStudentDetails(StudentEntity se) {
        return null;
    }

    @Override
    public StudentEntity updateStudentDetails(StudentEntity se) {
        return studentRepo.save(se);
    }

    @Override
    public StudentEntity saveStudentDetails(StudentEntity se) {
        return studentRepo.save(se);
    }

    @Override
    public StudentEntity getParticularStudent(String id) {
        return null;
    }

    @Override
    public boolean deleteStudent(Long id) {
        try {
            studentRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
