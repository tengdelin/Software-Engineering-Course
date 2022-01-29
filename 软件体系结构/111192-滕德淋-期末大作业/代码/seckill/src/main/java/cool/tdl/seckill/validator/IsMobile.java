package cool.tdl.seckill.validator;

import cool.tdl.seckill.vo.IsMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证手机号
 * @author tdl
 * @since 1.0.0
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})
public @interface IsMobile {

	boolean required() default true;

	String message() default "手机号码格式错误";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
