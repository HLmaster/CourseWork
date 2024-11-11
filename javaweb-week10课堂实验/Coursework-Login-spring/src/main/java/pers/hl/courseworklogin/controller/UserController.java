package pers.hl.courseworklogin.controller;

import pers.hl.courseworklogin.po.User;
import pers.hl.courseworklogin.result.R;
import pers.hl.courseworklogin.result.Result;
import pers.hl.courseworklogin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HL
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService  userService;

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        String name = user.getUsername();
        String password = user.getPassword();
        User userDB = userService.getByNameAndPassword(name,password);
        if(userDB==null){
            return Result.error("没有该用户");
        }
        return Result.success(userDB);

    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result regiseter(@RequestBody User user){
        String name = user.getUsername();
        User checkName = userService.getByName(name);
        if(checkName!=null){
            return Result.error("用户名已被注册");
        }
        userService.addUser(user);
        return Result.success(user);

    }
}
