package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.response.GlobalResponse;
import com.example.demo.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImp serviceImp;


    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
        List<StudentEntity> entityList = serviceImp.getAllStudent();
        if (entityList == null || entityList.size() < 1) {
            GlobalResponse gb = new GlobalResponse("Data not Found", HttpStatus.NOT_FOUND.value(), null);
            return new ResponseEntity<>(gb, HttpStatus.OK);
        }
        GlobalResponse gb = new GlobalResponse("success",HttpStatus.OK.value(), entityList);
        return new ResponseEntity<>(gb, HttpStatus.OK);
    }

    @GetMapping("/getAllStudentsById/{id}")
    public ResponseEntity<?> getAllStudentsById(@PathVariable() Long id) {
        StudentEntity entityList = serviceImp.getAllStudentById(id);
        if (entityList == null ) {
            GlobalResponse gb = new GlobalResponse("Data not Found",HttpStatus.NOT_FOUND.value(), null);
            return new ResponseEntity<>(gb, HttpStatus.OK);
        }
        GlobalResponse gb = new GlobalResponse("success",HttpStatus.OK.value(), entityList);
        return new ResponseEntity<>(gb, HttpStatus.OK);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody StudentEntity s) {
        StudentEntity ss = serviceImp.saveStudentDetails(s);
        GlobalResponse gb = new GlobalResponse("success",HttpStatus.OK.value(), ss);
        return new ResponseEntity<>(gb, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudents(@PathVariable Long id) {
        boolean b = serviceImp.deleteStudent(id);
        if(b) {
            GlobalResponse gb = new GlobalResponse("success", HttpStatus.OK.value(), "Data Deleted " + id);
            return new ResponseEntity<>(gb, HttpStatus.OK);
        }
        GlobalResponse gb = new GlobalResponse("UnSuccess", HttpStatus.NOT_FOUND.value(), "Data Not Found for Delete Operation " + id);
        return new ResponseEntity<>(gb, HttpStatus.OK);
    }

    @PostMapping("/editStudent")
    public ResponseEntity<?> editStudent(@RequestBody StudentEntity s) {
        if (s.getId() == null || s.getId().equals("")) {
            GlobalResponse gb = new GlobalResponse("UnSuccess",HttpStatus.BAD_REQUEST.value(), "UUid Required");
            return new ResponseEntity<>(gb, HttpStatus.OK);
        }
        StudentEntity ss = serviceImp.updateStudentDetails(s);
        GlobalResponse gb = new GlobalResponse("success",HttpStatus.OK.value(), ss);
        return new ResponseEntity<>(gb, HttpStatus.OK);
    }
}
