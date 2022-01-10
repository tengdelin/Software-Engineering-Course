package cool.tdl.springbootmyemail.service;

import cool.tdl.springbootmyemail.mapper.UserMapper;
import cool.tdl.springbootmyemail.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author administrator
 * @Description
 * @create 2021-12-23 下午2:55
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User queryStuByname(String name) {
        return userMapper.queryUserByname(name);
    }

    public int insertUser(String username, String password) {
        return userMapper.insertUser(username, password);
    }
}
