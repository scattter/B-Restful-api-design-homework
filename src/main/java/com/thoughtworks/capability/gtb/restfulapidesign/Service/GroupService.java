package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {

    private final int GROUP_NUM = 4;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public Map<Group, List<Student>> splitGroup() {
        Map<Group, List<Student>> randomGroups = new HashMap<>();
        List<Student> studentsList = studentRepository.getStudents();
        int surplus = studentsList.size() % GROUP_NUM;
        int eachGroupBaseNum = studentsList.size() / GROUP_NUM;

        Collections.shuffle(studentsList);
        for (int i = 0; i < GROUP_NUM; i++) {
            int groupSize = randomGroups.size();
            eachGroupBaseNum = surplus > 0 ? eachGroupBaseNum+1 : eachGroupBaseNum;
            randomGroups.put(new Group(i + 1, "Team" + "-" + (i + 1), ""), studentsList.subList(groupSize, groupSize + eachGroupBaseNum));
            surplus--;
        }
        return randomGroups;
    }
}
