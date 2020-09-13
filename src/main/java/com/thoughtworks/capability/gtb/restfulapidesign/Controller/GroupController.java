package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/split")
    public Map<Group, List<Student>> splitGroup() {
        return this.groupService.splitGroup();
    }

    @PutMapping("/update/{groupId}")
    public void updateGroupName(@PathVariable Integer groupId,
                                @RequestBody String groupName) {
        this.groupService.updateGroupName(groupId, groupName);
    }

    @GetMapping("")
    public Map<Group, List<Student>> getGroup() {
        return this.groupService.getGroup();
    }

}
