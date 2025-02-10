package com.student.consumer.controller;

import com.student.consumer.entity.StudentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consume")
public class StudentConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public ResponseEntity<List<StudentData>> getStudent(){
  ResponseEntity<List<StudentData>> response=
          restTemplate.exchange("http://STUDENT-SERVICE/student/getAll", HttpMethod.GET,null , new ParameterizedTypeReference<List<StudentData>>() {});
  return response;
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Optional<StudentData>> getStudentId(@PathVariable("id") int id){
        ResponseEntity<Optional<StudentData>> response = restTemplate.exchange(
                "http://STUDENT-SERVICE/student/getById/{id}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Optional<StudentData>>() {},id
        );
        return response;
    }
}
