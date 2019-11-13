package addressbook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import addressbook.domain.User;

/**
 * Media Type 控制器.
 * 
 * @author 
 * @date 
 */
@RestController
public class MediaTypeController {

	/**
	 * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
	 * 
	 * @return
	 */
	@RequestMapping("/user")
	public User getUser() {
		return new User("小明", 18);
	}

}
