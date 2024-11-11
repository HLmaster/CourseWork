package pers.hl.courseworklogin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.hl.courseworklogin.po.User;

/**
 *
 * @author HL
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户名和密码查询用户
     * @param name
     * @param password
     * @return
     */
    User selectByNameAndPassword(String name, String password);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User getByName(String name);

    /**
     * 添加用户
     * @param user
     */
    void insertInfo(User user);
}
