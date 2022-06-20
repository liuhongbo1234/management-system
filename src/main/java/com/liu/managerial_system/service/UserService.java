package com.liu.managerial_system.service;

import com.liu.managerial_system.domain.User;
import com.liu.managerial_system.domain.UserExample;
import com.liu.managerial_system.dto.UserDto;
import com.liu.managerial_system.mapper.UserMapper;
import com.liu.managerial_system.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liuhongbo
 * @description : TODO
 * @date : 2022/5/3 23:31
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void insertUser(User user) {
        userMapper.insert(user);
    }

    public User getUserByNameAndPwd(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (!userList.isEmpty()) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public UserDto getUserByName(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (!userList.isEmpty()) {
            return CopyUtil.copy(userList.get(0), UserDto.class);
        } else {
            return null;
        }
    }
}
