package addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * 设置默认主页面控制器
 * @author 熊子洵
 * @date 2019/10/23
 */
@Controller
@RequestMapping("/")
public class HelloController {

	@RequestMapping("/")
	public String hello() {
	    return "login_page";
	}
}
