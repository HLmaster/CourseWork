package pers.hl.courseworklogin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pers.hl.courseworklogin.po.User;

/**
 * @author HL
 * @since 2024-11-10
 */
public interface UserService extends IService<User> {

    User getByNameAndPassword(String name,String password);

    User getByName(String name);

    void addUser(User user);
}
