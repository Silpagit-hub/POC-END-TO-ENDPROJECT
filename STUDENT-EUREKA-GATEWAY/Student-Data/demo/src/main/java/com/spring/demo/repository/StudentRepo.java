package com.spring.demo.repository;

import com.spring.demo.entity.StudentData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<StudentData,Integer> {
}
