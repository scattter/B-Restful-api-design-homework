package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getStudent(String gender) {
        return this.studentRepository.getStudentByGender(gender);
    }

    public Student getStudentById(Integer id) {
        return this.studentRepository.getStudentById(id);
    }

    public void updateStudentInfo(Student student) {
        this.studentRepository.updateStudentInfo(student);
    }
}
