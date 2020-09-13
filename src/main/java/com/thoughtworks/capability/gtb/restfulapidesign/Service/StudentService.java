package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void addStudent(Student student) {
        studentRepository.getStudents().add(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.getStudents()
                .removeIf(it -> it.getStudentId().equals(id));
    }

    public List<Student> getStudentByGender(String gender) {
        List<Student> studentList = this.studentRepository.getStudents();
        return "".equals(gender) ? studentList : studentList
                .stream()
                .filter(it -> it.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public Student getStudentById(Integer id) {
        return this.studentRepository.getStudents()
                .stream()
                .filter(it -> it.getStudentId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    public void updateStudentInfo(Student student) {
        this.studentRepository.getStudents()
                .forEach(it -> {
                    if (it.getStudentId().equals(student.getStudentId())) {
                        it.setStudentName(student.getStudentName());
                        it.setGender(student.getGender());
                        it.setStudentNotes(student.getStudentNotes());
                    }
                });
    }

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }
}
