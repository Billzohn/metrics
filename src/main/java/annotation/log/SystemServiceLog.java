package annotation.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *@Author yinpengfei 
 *下午2:19:59
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface SystemServiceLog {
	
	 //表示第几个参数对象
	 int index() default 0;
	 //日志文字声明
	 String description()  default "";
	 //对象中的那个方法
	 String content() default "";
}
