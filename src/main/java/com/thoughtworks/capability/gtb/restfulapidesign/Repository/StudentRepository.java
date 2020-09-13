package com.thoughtworks.capability.gtb.restfulapidesign.Repository;


import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    {
        students.add(new Student(1, "沈乐棋", "male", "good"));
        students.add(new Student(2, "徐慧慧", "female", "good"));
        students.add(new Student(3, "陈思聪", "male", "good"));
        students.add(new Student(4, "王江林", "male", "good"));
        students.add(new Student(5, "王登宇", "male", "good"));
        students.add(new Student(6, "杨思雨", "female", "good"));
        students.add(new Student(7, "江雨舟", "male", "good"));
        students.add(new Student(8, "廖燊", "male", "good"));
    }

    public List<Student> getStudents() {
        return students;
    }

}
