package com.example.demo.controller;


import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@CrossOrigin("*")

public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student){

        studentService.create(student);
        String message= "Student saved successfully.";
        return ResponseEntity.ok(message);

    }
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
      List<Student> students =  studentService.getAll();
      return ResponseEntity.ok(students);


    }
    @GetMapping("find/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student=studentService.findById(id);
      return  ResponseEntity.ok(student);


    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        String message = "Student deleted successfully.";
        return ResponseEntity.ok(message);

    }
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student studentdata){
        studentService.updateStudent(id,studentdata);
        String message= "Student updated successfully.";
        return ResponseEntity.ok(message);
    }
    @GetMapping("/{keyword}")
    public ResponseEntity<List<Student>>findByFirstName(@PathVariable String keyword){

        return ResponseEntity.ok(studentService.findByFirstName(keyword));
    }
}

