package com.liu.managerial_system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liu.managerial_system.domain.*;
import com.liu.managerial_system.dto.TaskDto;
import com.liu.managerial_system.dto.UserDto;
import com.liu.managerial_system.dto.UserTaskDto;
import com.liu.managerial_system.mapper.TaskMapper;
import com.liu.managerial_system.mapper.UserMapper;
import com.liu.managerial_system.mapper.UserTaskMapper;
import com.liu.managerial_system.util.CopyUtil;
import com.liu.managerial_system.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/8 21:34
 */
@Service
public class TaskService {
    @Resource
    TaskMapper taskMapper;
    @Resource
    UserTaskMapper userTaskMapper;
    @Resource
    UserMapper userMapper;

    public void assignNewTask(TaskDto taskDto) {
        taskDto.setId(UuidUtil.getShortUuid());
        UserTaskDto userTaskDto = new UserTaskDto();
        userTaskDto.setTaskid(taskDto.getId());
        userTaskDto.setNewtask("0");
        userTaskDto.setAssigner(taskDto.getName());

        String name = taskDto.getName();
        UserExample userExample1 = new UserExample();
        userExample1.createCriteria().andUsernameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample1);
        String role = users.get(0).getMyrole();
        UserExample userExample2 = new UserExample();
        if (role.equals("role2")) {
            userExample2.createCriteria().andDepartmentEqualTo(taskDto.getAssigndepartment());
        }

        List<User> userList = userMapper.selectByExample(userExample2);
        List<UserDto> userDtoList = CopyUtil.copyList(userList, UserDto.class);
        for (UserDto userDto : userDtoList) {
            userTaskDto.setId(UuidUtil.getShortUuid());
            userTaskDto.setUsername(userDto.getUsername());
            userTaskDto.setDepartment(userDto.getDepartment());
            userTaskDto.setContent(taskDto.getContent());
            userTaskMapper.insert(CopyUtil.copy(userTaskDto, UserTask.class));
        }

        taskMapper.insert(CopyUtil.copy(taskDto, Task.class));
    }

    public String getAllTask() {
        TaskExample taskExample = new TaskExample();
        taskExample.setOrderByClause("start asc");
        List<Task> listTask = taskMapper.selectByExample(taskExample);
        List<TaskDto> taskDtoList = CopyUtil.copyList(listTask, TaskDto.class);
        JSONArray jsonArray = new JSONArray();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Calendar calendar = Calendar.getInstance();
        for (TaskDto taskDto : taskDtoList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", taskDto.getContent());
            jsonObject.put("start", taskDto.getStart());
            Date date = null;
            try {
                date = simpleDateFormat.parse(taskDto.getEnd());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            jsonObject.put("end", simpleDateFormat.format(calendar.getTime()));
            jsonObject.put("id", taskDto.getId());
            jsonObject.put("className", "label-primary");
            jsonObject.put("allDay", "true");
            jsonArray.add(jsonObject);
        }
//        Logger LOG = LoggerFactory.getLogger(TaskService.class);
//        LOG.info(jsonArray.toString());
        return jsonArray.toString();
    }

    public String getNewTaskByDepartment(String department) {
        TaskExample taskExample = new TaskExample();
        taskExample.setOrderByClause("start desc");
        List<String> depart = new ArrayList<>();
        depart.add(department);
        depart.add("办公室");
        taskExample.createCriteria().andAssigndepartmentIn(depart);
        List<Task> taskList = taskMapper.selectByExample(taskExample);
        List<TaskDto> taskDtoList = CopyUtil.copyList(taskList, TaskDto.class);
        return JSON.toJSONString(taskDtoList);
    }

    public String getMyNewTask(String username) {
        UserTaskExample userTaskExample = new UserTaskExample();
        userTaskExample.createCriteria().andUsernameEqualTo(username).andNewtaskEqualTo("0");
        List<UserTask> userTasks = userTaskMapper.selectByExample(userTaskExample);
        List<UserTaskDto> userTaskDtoList = CopyUtil.copyList(userTasks, UserTaskDto.class);
        return JSON.toJSONString(userTaskDtoList);
    }

    public String userKnowTask(String taskid, String username) {
        UserTaskExample userTaskExample = new UserTaskExample();
        userTaskExample.createCriteria().andTaskidEqualTo(taskid).andUsernameEqualTo(username);
        UserTaskDto userTaskDto = new UserTaskDto();
        userTaskDto.setNewtask("1");
        userTaskMapper.updateByExampleSelective(CopyUtil.copy(userTaskDto, UserTask.class), userTaskExample);
        List<UserTask> userTaskList = userTaskMapper.selectByExample(userTaskExample);
        UserTaskDto userTaskDto1 = CopyUtil.copyList(userTaskList, UserTaskDto.class).get(0);
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andIdEqualTo(userTaskDto1.getTaskid());
        List<TaskDto> taskDtoList = CopyUtil.copyList(taskMapper.selectByExample(taskExample), TaskDto.class);
        String msg = "来自" + userTaskDto1.getAssigner() + "的通知：</br>" + userTaskDto1.getContent() + "</br>截至日期：" + taskDtoList.get(0).getEnd();
        return msg;
    }

    public List<TaskDto> getAllTaskByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        String department = userList.get(0).getDepartment();
        TaskExample taskExample = new TaskExample();
        List<String> roles = new ArrayList<>();
        roles.add("role1");
        roles.add("role4");
        UserExample userExample1 = new UserExample();
        userExample1.createCriteria().andMyroleIn(roles);
        userList = userMapper.selectByExample(userExample1);
        List<String> highUser = new ArrayList<>();
        if (userList != null && !userList.isEmpty()) {
            for (int i = 0; i < userList.size(); i++) {
                highUser.add(userList.get(i).getUsername());
            }
        }

        taskExample.setOrderByClause("start desc");
        taskExample.or().andAssigndepartmentEqualTo(department);
        taskExample.or().andNameIn(highUser);
        List<Task> taskList = taskMapper.selectByExample(taskExample);
        return CopyUtil.copyList(taskList, TaskDto.class);
    }

    public void deleteTaskById(String id) {
        taskMapper.deleteByPrimaryKey(id);
    }

    public void changeTaskById(String content, String id) {
        TaskExample taskExample = new TaskExample();
        taskExample.createCriteria().andIdEqualTo(id);
        TaskDto taskDto = new TaskDto();
        taskDto.setContent(content);
        taskDto.setId(UuidUtil.getShortUuid());
        taskMapper.updateByExampleSelective(CopyUtil.copy(taskDto, Task.class), taskExample);
        UserTaskExample userTaskExample = new UserTaskExample();
        userTaskExample.createCriteria().andTaskidEqualTo(id);
        UserTask userTask = new UserTask();
        userTask.setTaskid(taskDto.getId());
        userTask.setNewtask("0");
        userTask.setContent(content);
        userTaskMapper.updateByExampleSelective(userTask, userTaskExample);
    }
}
