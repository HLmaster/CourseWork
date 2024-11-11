package pers.hl.courseworklogin.po;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author HL
 */
@Data
public class User implements Serializable {

    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}
