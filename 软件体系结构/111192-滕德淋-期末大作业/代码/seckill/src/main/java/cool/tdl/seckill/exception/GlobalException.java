package cool.tdl.seckill.exception;

import cool.tdl.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 * @author tdl
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
	private RespBeanEnum respBeanEnum;
}