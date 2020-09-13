package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class GroupRepository {
    private Map<Group, List<Student>> groups;

    public void save(Map<Group, List<Student>> randomGroups) {
        this.groups = randomGroups;
    }

    public Map<Group, List<Student>> getGroups() {
        return groups;
    }
}
