package cool.tdl.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author tdl
 * @since 2022-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID 手机号码")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "MD5加密")
    private String password;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "头像")
    private String head;

    @ApiModelProperty(value = "注册时间")
    private Date registerData;

    @ApiModelProperty(value = "最后一次登录时间")
    private Date lastLoginDate;

    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;

    @ApiModelProperty(value = "地址")
    private String address;

}
