package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public void create(Student student) {
        studentRepository.save(student);
    }
    public List<Student> getAll(){
       return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->null);
    }

    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()-> null);
        studentRepository.delete(student);
    }

    public void updateStudent(Long id, Student newStudent) {
        Student oldStudent = studentRepository.findById(id).orElseThrow(()->null);
        oldStudent.setActive(newStudent.getActive());
        oldStudent.setEmail(newStudent.getEmail());
        oldStudent.setAddress(newStudent.getAddress());
        oldStudent.setGender(newStudent.getGender());
        oldStudent.setStatus(newStudent.getStatus());
        oldStudent.setDob(newStudent.getDob());
        oldStudent.setFirstName(newStudent.getFirstName());
        oldStudent.setLastName(newStudent.getLastName());
        oldStudent.setPhoneNumber(newStudent.getPhoneNumber());
        studentRepository.save(oldStudent);

    }

    public List<Student> findByFirstName(String keyword) {
        return studentRepository.findByFirstNameContaining(keyword);
    }
}
