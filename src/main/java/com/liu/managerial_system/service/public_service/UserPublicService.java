package com.liu.managerial_system.service.public_service;

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
 * @date : 2022/5/6 17:27
 */
@Service
public class UserPublicService {
    @Resource
    UserMapper userMapper;

    public List<UserDto> getAllUserList() {
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        List<User> userList = userMapper.selectByExample(userExample);
        return CopyUtil.copyList(userList, UserDto.class);
    }
}
