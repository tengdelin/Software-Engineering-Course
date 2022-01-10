package cool.tdl.springbootmyemail.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author administrator
 * @Description
 * @create 2021-12-23 下午1:58
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String perm;
}
