package annotation.log;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author yinpengfei 下午2:22:19
 */
@Aspect
@Component
public class SystemLogAspect {
	// 本地日志记录对象
	private final Logger log = LoggerFactory.getLogger(getClass());

	// Service层切点
	@Pointcut("@annotation(annotation.log.SystemServiceLog)")
	public void serviceAspect() {
	}

	// Controller层切点
	@Pointcut("@annotation(annotation.log.SystemControllerLog)")
	public void controllerAspect() {
	}
	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		try {
			log.info("Controller==="
					+ getControllerMethodDescription(joinPoint));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 置通知 用于拦截service层记录用户的操作
	 * 
	 * @param joinPoint
	 *            切点
	 */
	@AfterReturning("serviceAspect()")
	public void doAfterReturning(JoinPoint joinPoint) {
		try {
			log.info("Service===" + getServiceMethodDescription(joinPoint));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterThrowing(pointcut="serviceAspect()",throwing="e")
	public void doAfter(JoinPoint joinPoint,Exception e) {
		try {
			 
			log.info("Service===" + getServiceMethodDescription(joinPoint));
			if(e!=null){  
				log.info("执行异常:" + e.getMessage());  
	        }
		} catch (Exception e1) {
			e.printStackTrace();
		}
	}
	
	// 获取controller的注解说明
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		// 获取注解参数值
		String description = "";
		String content = "";
		int index = 0;
		// 返回结果
		String result = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SystemControllerLog.class).description();
					content = method.getAnnotation(SystemControllerLog.class)
							.content();
					index = method.getAnnotation(SystemControllerLog.class)
							.index();
					break;
				}
			}
		}
//		if (!"".equals(content)) {
//			// 获取方法
//		//	Method m = arguments[index].getClass().getMethod(content);
//			// 调用方法
//			result = String.valueOf(m.invoke(arguments[index]));
//		} else {
//			result = String.valueOf(arguments[index]);
//		}
		return  targetName+"====="+ methodName+"=====" + description + "=====" + result;
	}

	// 获取service的注解说明
	public static String getServiceMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		// 获取注解参数值
		String description = "";
		String content = "";
		int index = 0;
		// 返回结果
		String result = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class)
							.description();
					content = method.getAnnotation(SystemServiceLog.class)
							.content();
					index = method.getAnnotation(SystemServiceLog.class)
							.index();
					break;
				}
			}
		}
		if (!"".equals(content)) {
			// 获取方法
			Method m = arguments[index].getClass().getMethod(content);
			// 调用方法
			result = String.valueOf(m.invoke(arguments[index]));
		} else {
			result = String.valueOf(arguments[index]);
		}
		return  targetName+"====="+ methodName+"=====" + description + "=====" + result;
	}
}
