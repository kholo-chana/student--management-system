package com.kholofelo.service;

import com.kholofelo.exception.ResourceNotFoundException;
import com.kholofelo.model.Student;
import com.kholofelo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {

        Optional <Student> studentDb = this.studentRepository.findById(student.getId());

        if (studentDb.isPresent()){
            Student studentUpdate = studentDb.get();
            studentUpdate.setId(student.getId());
            studentUpdate.setFirstName(student.getFirstName());
            studentUpdate.setLastName(student.getLastName());
            studentUpdate.setEmailId(student.getEmailId());
            return studentUpdate;
        }  else {
            throw new ResourceNotFoundException("Record not found with id : " + student.getId());
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long studentId) {

        Optional < Student > studentDb = this.studentRepository.findById(studentId);
        if (studentDb.isPresent()) {
            return studentDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }
    }

    @Override
    public void deleteStudent(long studentId) {

        Optional < Student > studentDb = this.studentRepository.findById(studentId);

        if (studentDb.isPresent()) {
            this.studentRepository.delete(studentDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + studentId);
        }

    }
}
