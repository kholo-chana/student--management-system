package com.kholofelo.controller;

import com.kholofelo.model.Student;
import com.kholofelo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity < List < Student >> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getAllStudent());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity < Student > getStudentById(@PathVariable long id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity < Student > createStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(this.studentService.createStudent(student));
    }

    @PutMapping("/students/{id}")
    public ResponseEntity < Student > updateStudent(@PathVariable long id, @RequestBody Student student) {
        student.setId(id);
        return ResponseEntity.ok().body(this.studentService.updateStudent(student));
    }

    @DeleteMapping("/students/{id}")
    public HttpStatus deleteStudent(@PathVariable long id) {
        this.studentService.deleteStudent(id);
        return HttpStatus.OK;
    }
}