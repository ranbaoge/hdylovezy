package hdy.zy.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hdy.zy.system.entity.User;
import hdy.zy.system.service.UserService;

/**
 * @author huangdaye
 *用户Controller层
 */
@Controller
@RequestMapping("/System_User")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	private Logger logger=Logger.getLogger(UserController.class);
	
	/**
	 * 验证登录
	 * @param user
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(User user,HttpServletRequest request){
		logger.info("登录信息:"+user);
		User u=userService.login(user);
		if(u!=null){
			User u1= userService.queryUserById(u.getId());
			request.getSession().setAttribute("username", u1.getName());
			request.getSession().setAttribute("role", u1.getRoleSet());
			request.getSession().setAttribute("department", u1.getDepartment().getName());
			request.getSession().setAttribute("loginname", u1.getLoginname());
			return "index";
		}else{
			return "System_User/login";
		}
		
	}
	
	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	@RequestMapping("save.do")
	public String saveUser(User user,
			               @RequestParam long page,Model model){
		int rs= userService.saveUser(user);
		logger.info("添加了"+rs+"行数据");
		return queryAllByPage(page, model);
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@RequestMapping("update.do")
	public String updateUser(User user,
			                 @RequestParam long page,Model model){
		int rs=userService.updateUser(user);
		logger.info("修改了"+rs+"行数据");
		return queryAllByPage(page, model);
	}
	
	/**
	 * 根据ID删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("delete.do")
	public String deleteUserById(@RequestParam(value="id",required=true) long id,
			                     @RequestParam long page,Model model){
		int rs=userService.deleteUserById(id);
		logger.info("删除了"+rs+"行数据");
		return queryAllByPage(page, model);
	}
	
	/**
	 * 根据ID查询用户
	 * @return
	 */
	@RequestMapping("query1.do")
	public String queryUserById(@RequestParam(value="id",required=true) long id,
			                    Model model){
		
	     User user=userService.queryUserById(id);
	     model.addAttribute("user", user);
		return "System_User/list";
		
	}
	
	/**
	 * 分页查询功能
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("query2.do")
	public String queryAllByPage(@RequestParam long page,Model model){
		long count =userService.count();
		long pageSize=8;
		long endPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(page<=1){
			page=1;
		}
		if(page>=endPage){
			page=endPage;
		}
		Map<String, Long> map=new HashMap<String,Long>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> list= userService.queryAllByPage(map);
		for (User user : list) {
			System.out.println(user+"\t"+user.getRoleSet());
		}
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "System_User/list";
	}
	
	/**
	 * 分页查询模糊功能
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("query3.do")
	public String queryAllByLike(@RequestParam long page,
			                     @RequestParam String name,
			                     Model model){
		long count =userService.count();
		long pageSize=8;
		long endPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(page<=1){
			page=(long) 1;
		}
		if(pageSize>=endPage){
			page=endPage;
		}
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("name", name);
		List<User> list= userService.queryAllByLike(map);
		
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "System_User/list";
	}
	
	
	public String repassword(@RequestParam String loginname,
			                 @RequestParam String password,
			                 @RequestParam String repassword,
			                 @RequestParam String repasswordRegister,
			                 Model model){
		
		
		return "redirect:login";
		
	}
	
}
