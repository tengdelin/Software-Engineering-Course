package cool.tdl.seckill.mapper;

import cool.tdl.seckill.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author tdl
 * @since 2022-01-05
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
