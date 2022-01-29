package cool.tdl.seckill.vo;


import cool.tdl.seckill.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author tdl
 * @Date 2022/1/6 21:28
 * @description 登录参数实体对象
 * @Version 1.0
 */
@Data
public class LoginVo {
    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;

}
