package cool.tdl.springbootmyemail.mapper;

import cool.tdl.springbootmyemail.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author administrator
 * @Description
 * @create 2021-12-23 下午3:17
 */

@Repository
@Mapper
public interface UserMapper {
    User queryUserByname(String username);
    int insertUser(String username,String password);
}
