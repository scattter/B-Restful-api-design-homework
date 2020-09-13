package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        this.studentService.deleteStudent(id);
    }

}
