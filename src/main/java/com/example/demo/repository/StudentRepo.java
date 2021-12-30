package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, Long> {

    @Query(value = "SELECT t FROM StudentEntity t")
    List<StudentEntity> getAllRecords();
}
