package metrics.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metrics.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
*@Author yinpengfei 
*上午11:48:44
*/

public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		  //当登陆成功是，将用户信息存放到session中去
        HttpSession session = request.getSession();
        String name=(String)session.getAttribute("name");
        System.out.println("name===="+name);
		 if (StringUtils.isEmpty(name)) {
       	  		 //被拦截，重定向到login界面
       	         response.sendRedirect("/login");
       	         return false;
	      }
		     return true;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
}
