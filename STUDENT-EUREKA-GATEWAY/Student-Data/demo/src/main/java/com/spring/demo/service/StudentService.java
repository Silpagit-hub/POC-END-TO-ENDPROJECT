package com.spring.demo.service;


import com.spring.demo.entity.StudentData;
import com.spring.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;


    public StudentData saveStudent(StudentData entity) {
        return studentRepo.save(entity);
    }

    public List<StudentData> getAllStudent(){
      List <StudentData>list =studentRepo.findAll();
       return list;
    }

    public Optional<StudentData> getStudentId(int id){
        return studentRepo.findById(id);
    }

    public Optional<StudentData> updateSudent(StudentData student,int id){
        Optional<StudentData> existing= studentRepo.findById(id);

        if (existing.isPresent()) {
            StudentData updatedStudent = existing.get();
            updatedStudent.setName(student.getName());
            updatedStudent.setStandard(student.getStandard());
            studentRepo.save(updatedStudent);

            return Optional.of(updatedStudent);
        }
        return Optional.empty();
    }

    public void deleteData(int id){
        studentRepo.deleteById(id);
        System.out.println("Student data deleted for Id : "+id);

    }
}
