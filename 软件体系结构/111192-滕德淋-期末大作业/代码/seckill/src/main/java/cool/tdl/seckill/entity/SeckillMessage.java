package cool.tdl.seckill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tdl
 * @Date 2022/1/9 19:42
 * @description XXX
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeckillMessage {
    private User user;
    private Long goodsId;
}
