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

    private final int GROUP_NUM = 6;
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
        int startIndex = 0;

        Collections.shuffle(studentsList);
        for (int i = 0; i < GROUP_NUM; i++) {
            int currentAddNum = surplus > 0 ? eachGroupBaseNum + 1 : eachGroupBaseNum;
            randomGroups.put(new Group(i + 1, "Team" + "-" + (i + 1), ""), studentsList.subList(startIndex, (startIndex + currentAddNum)));
            startIndex += currentAddNum;
            surplus--;
        }
        groupRepository.save(randomGroups);
        return groupRepository.getGroups();
    }

    public void updateGroupName(Integer groupId, String groupName) {
        groupRepository.getGroups().forEach((group, lst) -> {
            if (group.getGroupId().equals(groupId)) {
                group.setGroupName(groupName);
            }
        });
    }

    public Map<Group, List<Student>> getGroup() {
        return this.groupRepository.getGroups();
    }
}
