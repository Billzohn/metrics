package metrics.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metrics.model.User;
import metrics.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import annotation.log.SystemControllerLog;

@Controller
public class MainController {
	private Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		 session.setAttribute("name", "");
      	 session.setAttribute("power","");
		return "login";
	}
	@RequestMapping("/check")
	public String check(String name,String pass,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(name!=null&&pass!=null){
			 User  u=userService.quertUser(name, pass);
			 System.out.println("u.=="+u.getName()+" "+u.getPass());
			  if(u!=null){
		       		 //设置session属性
		           	  session.setAttribute("name", name);
		           	  session.setAttribute("power", u.getPower());
		           	 //被拦截，重定向到login界面
		       	  		}else{
		       	  		 //被拦截，重定向到login界面
		       	  		return "login";
		       	  		}
		}
		return "index";
	}
	
	@RequestMapping("/index")
	@SystemControllerLog(description="创建元词:")
	public String index() {
		return "index";
	}
	@RequestMapping("/association")
	public String association() {
		return "association";
	}
	@RequestMapping("/document")
	public String document() {
		return "document";
	}
	@RequestMapping("/manager")
	public String manager() {
		return "manager";
	}
}
