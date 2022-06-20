package com.liu.managerial_system.controller.user;

import com.liu.managerial_system.domain.User;
import com.liu.managerial_system.dto.UserDto;
import com.liu.managerial_system.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/6/19 22:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/ifExistUser")
    public String existUser(String username) {
        UserDto userDto = userService.getUserByName(username);
        if (userDto != null) {
            return "yes";
        } else {
            return "no";
        }
    }
}
