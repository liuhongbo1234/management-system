package com.liu.managerial_system.controller;

import com.liu.managerial_system.domain.User;
import com.liu.managerial_system.dto.AchievementDto;
import com.liu.managerial_system.dto.ForleaveDto;
import com.liu.managerial_system.dto.TaskDto;
import com.liu.managerial_system.service.AchievementService;
import com.liu.managerial_system.service.LeaveService;
import com.liu.managerial_system.service.TaskService;
import com.liu.managerial_system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/4/28 8:12
 */
@Controller
public class MainController {
    @Resource
    private TaskService taskService;
    @Resource
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @Autowired(required = false)
    private HttpServletResponse response;
    @Resource
    private AchievementService achievementService;
    @Resource
    private LeaveService leaveService;

    @PostMapping("/index")
    public String index(@ModelAttribute(value = "user") User user, Model model) {
        User loginUser = userService.getUserByNameAndPwd(user.getUsername(), user.getPassword());
        if (loginUser != null) {
            request.getSession().setAttribute("user", loginUser);
            Cookie usernameCookie = new Cookie("username", loginUser.getUsername());
            Cookie passwordCookie = new Cookie("password", loginUser.getPassword());
            Cookie stateCookie = new Cookie("outstate", loginUser.getOut());
            usernameCookie.setMaxAge(Integer.MAX_VALUE);
            passwordCookie.setMaxAge(Integer.MAX_VALUE);
            stateCookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            response.addCookie(stateCookie);
            return "index";
        } else {
            model.addAttribute("errorNameAndPwd", "用户名或密码错误");
            return "login";
        }
    }

    @PostMapping("/regist")
    public String regist(@ModelAttribute(value = "user") User user) {
        userService.insertUser(user);
        return "login";
    }

    @RequestMapping("/*")
    public String login() {
        if (request.getSession().getAttribute("user") != null) {
            return "index";
        }
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
            if (username != null && password != null) {
                User user = userService.getUserByNameAndPwd(username, password);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    return "index";
                }
            }
        }
        return "login";
    }

    @RequestMapping("/calendar")
    public String calendar() {
        return "calendar";
    }

    @RequestMapping("/mytimetable")
    public String mytimetable() {
        return "mytimetable";
    }

    @RequestMapping("/alltimetable")
    public String alltimetable() {
        return "alltimetable";
    }

    @RequestMapping("/leave")
    public String leave() {
        return "leave";
    }

    @RequestMapping("/alltask")
    public String alltask(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        List<TaskDto> taskDtoList = taskService.getAllTaskByUsername(user.getUsername());
        model.addAttribute("taskDtoList", taskDtoList);
        return "alltask";
    }

    @RequestMapping("/my-achievements")
    public String myAchievements() {
        return "my-achievements";
    }

    @RequestMapping("/showmyachievement")
    public String showMyAchievement(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        List<AchievementDto> achievementDtos = achievementService.getAllAchievementByUsername(username);
        model.addAttribute("achievementList", achievementDtos);
        return "showmyachievement";
    }

    @RequestMapping("/showallachievement")
    public String showAllAchievement(Model model) {
        List<AchievementDto> achievementDtos = achievementService.getAllAchievement();
        model.addAttribute("achievementList", achievementDtos);
        return "showallachievement";
    }

    @RequestMapping("/criticism")
    public String showCriticism() {
        return "criticism";
    }

    @RequestMapping("/questionnaire")
    public String showQuestionnaire() {
        return "questionnaire/question";
    }

    @RequestMapping("/questionnaire_result")
    public String showQuesResult() {
        return "questionnaire/ques_result";
    }

    @RequestMapping("/allleave")
    public String showAllLeave(Model model) {
        List<ForleaveDto> forleaveDtoList = leaveService.getAllLeave();
        model.addAttribute("forleaveDtoList", forleaveDtoList);
        return "leave/allleave";
    }

    @RequestMapping("/myleave")
    public String showMyLeave(Model model) {
        User user = (User) request.getSession().getAttribute("user");
        List<ForleaveDto> myLeave = leaveService.getMyLeaveMsg(user.getUsername());
        model.addAttribute("myLeave", myLeave);
        return "leave/myleave";
    }
}