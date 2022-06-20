package com.liu.managerial_system.controller.task;

import com.liu.managerial_system.dto.TaskDto;
import com.liu.managerial_system.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/8 21:13
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private TaskService taskService;

    @PostMapping("/assign_task")
    public void newTask(@ModelAttribute TaskDto taskDto) {
        taskService.assignNewTask(taskDto);
    }

    @RequestMapping("/put_task_on_calendar")
    public String putTask() {
        return taskService.getAllTask();
    }

    @RequestMapping("/check_new_task")
    public String checkNewTask(String department) {
        return taskService.getNewTaskByDepartment(department);
    }

    @RequestMapping("/check_my_new_task")
    public String checkMyNewTask(String username) {
        return taskService.getMyNewTask(username);
    }

    @RequestMapping("/i_know_new_task")
    public String iKnowNewTask(String taskid, String username) {
        return taskService.userKnowTask(taskid, username);
    }

    @PostMapping("/delete_task")
    public void deleteTaskById(String id) {
        taskService.deleteTaskById(id);
    }

    @PostMapping("/change_task")
    public void changeTask(String content, String id) {
        taskService.changeTaskById(content, id);
    }
}
