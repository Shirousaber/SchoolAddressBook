package addressbook.controller;

import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.util.Map;


/**
 * @author 熊子洵
   *  用于处理登陆请求
 *
 */
@RestController
public class LoginInController {
	
	@PostMapping("/userlogin")
	//从表单获取数据
	public ModelAndView login(@RequestParam("username") String username,
							  @RequestParam("password") String password,
							  Map<String, Object> map) {
		if(!StringUtils.isEmpty(username)||!StringUtils.isEmpty(password)){
			if(password.equals("1234"))
				return new ModelAndView("list");
			else
				map.put("msg","用户名或密码错误");
		}
		else{
			map.put("msg","用户名或者密码不能为空");
		}
		return new ModelAndView("login_page");
	}
}
