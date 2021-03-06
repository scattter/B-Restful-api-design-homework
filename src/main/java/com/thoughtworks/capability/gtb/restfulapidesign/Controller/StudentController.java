package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        this.studentService.addStudent(student);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteStudent(@PathVariable Integer id) {
        this.studentService.deleteStudent(id);
    }

    @GetMapping("/{gender}")
    public List<Student> getStudentByGender(@PathVariable(required = false) String gender) {
        return this.studentService.getStudentByGender(gender);
    }

    @GetMapping("")
    public List<Student> getStudent() {
        return this.studentService.getStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable Integer studentId) {
        return this.studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}/update")
    public void updateStudentInfo(@RequestBody Student student) {
        this.studentService.updateStudentInfo(student);
    }

}
