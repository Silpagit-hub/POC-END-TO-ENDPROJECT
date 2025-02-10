package com.spring.demo.controller;

import com.spring.demo.entity.StudentData;
import com.spring.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/save")
    public ResponseEntity<StudentData> saveStudents(@RequestBody StudentData entity){
        return new ResponseEntity<StudentData>(service.saveStudent(entity),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentData>> getAllStudents(){
        return new ResponseEntity<List<StudentData>>(service.getAllStudent(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<StudentData>> getByIds(@PathVariable("id") int id){
        return new ResponseEntity<Optional<StudentData>>(service.getStudentId(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<StudentData>> updateStudents(@PathVariable("id") int id,
                                                                @RequestBody StudentData student){
      return new ResponseEntity<Optional<StudentData>>(service.updateSudent(student,id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentData> deleteStudent(@PathVariable("id") int id){
        return new ResponseEntity<StudentData>(HttpStatus.OK);
    }

}
