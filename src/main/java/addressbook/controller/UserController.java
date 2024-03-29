package addressbook.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import addressbook.domain.User;
import addressbook.repository.UserRepository;

/**
 * 用户控制器.
 * 
 * @author 
 * @date 
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	private UserRepository userRepository;



	/**
	 * 查询所用用户
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("list", "userModel", model);
	}
 
	/**
	 * 根据id查询用户
	 * @param
	 * @return
	 */
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		return new ModelAndView("view", "userModel", model);
	}

	/**
	 * 获取 form 表单页面
	 * @param
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, 0));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("form", "userModel", model);
	}

	/**
	 * 新建用户
	 * @param user
	 * @param
	 * @param
	 * @return
	 */
	@PostMapping
	public ModelAndView create(User user) {
 		user = userRepository.save(user);
		return new ModelAndView("redirect:/users");
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userRepository.delete(id);
 
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("title", "删除用户");
		return new ModelAndView("list", "userModel", model);
	}

	/**
	 * 修改用户
	 * @param
	 * @return
	 */
	@GetMapping(value = "/modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		User user = userRepository.findOne(id);
 
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("form", "userModel", model);
	}

}
