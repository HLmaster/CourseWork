package pers.hl.courseworklogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pers.hl.courseworklogin.mapper.UserMapper;
import pers.hl.courseworklogin.po.User;
import pers.hl.courseworklogin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HL
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名和密码查询用户
     * @param name
     * @param password
     * @return
     */
    @Override
    public User getByNameAndPassword(String name,String password) {
        return userMapper.selectByNameAndPassword(name,password);

    }

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        userMapper.insertInfo(user);
    }
}
