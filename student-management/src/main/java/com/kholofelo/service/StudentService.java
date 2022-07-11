package com.kholofelo.service;

import com.kholofelo.model.Student;
import java.util.List;

public interface  StudentService {

    Student createStudent(Student student);

    Student updateStudent(Student student);

    List< Student > getAllStudent();

    Student getStudentById(long studentId);

    void deleteStudent(long id);
}
