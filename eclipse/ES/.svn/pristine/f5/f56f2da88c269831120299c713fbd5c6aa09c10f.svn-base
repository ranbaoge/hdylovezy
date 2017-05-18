package com.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.User;
import com.entity.UserClass;
import com.service.ClassService;
import com.service.UserService;

@Controller
public class UserController{
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="classService")
	private ClassService classService;
	
	@RequestMapping("login.do")
	public String login(User user,HttpSession session,HttpServletResponse response){
		User u=userService.login(user);
		if(u!=null){
			session.setAttribute("username", u.getUsername());
			return "index";
		}else{
			try {
				PrintWriter out=response.getWriter();
				out.println("<script type='text/javascript'>alert('Username Or Password is Error !!!');</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "login";
		}
	}
	
	@RequestMapping("save.do")
	public String saveUser(@RequestParam int page,
			               User user,Model model){
		userService.saveUser(user);
		return queryAllByPage(page, model);
	}
	
	@RequestMapping("repassword.do")
	public String updateUser(@RequestParam int page,
			                 @RequestParam String username,
			                 @RequestParam String repassword,Model model){
		Map<String, String> map=new HashMap<>();
		map.put("username", username);
		map.put("password", repassword);
		userService.updateUser(map);
		return queryAllByPage(page, model);
	}
	
	
	/**
	 * 分页查询功能
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("query.do")
	public String queryAllByPage(@RequestParam int page,Model model){
		int count =userService.count();
		int pageSize=8;
		int endPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(page<=1){
			page=1;
		}
		if(page>=endPage){
			page=endPage;
		}
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<User> list= userService.queryByPage(map);
		for (User user : list) {
			System.out.println(user);
		}
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "show";
	}
	
	@RequestMapping("queryByClass.do")
	public String queryByClass(@RequestParam int id,@RequestParam int page,Model model){
		int count =classService.count(id);
		int pageSize=8;
		int endPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
		
		if(page<=1){
			page=1;
		}
		if(page>=endPage){
			page=endPage;
		}
		Map<String, Integer> map=new HashMap<String,Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("id", id);
		List<UserClass> list= classService.queryByClass(map);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("id", list.get(0).getC_id());
		model.addAttribute("name", list.get(0).getC_name());
		model.addAttribute("set", list.get(0).getUserSet());
		return "show1";
		
	}
	
	
	
	@RequestMapping("delete.do")
	public String deleteUser(@RequestParam int id,
			                 @RequestParam int page ,Model model){
		userService.deleteUser(id);
		return queryAllByPage(page, model);
	}
	
	
	@RequestMapping("/upload.do")  
    public String upload(@RequestParam MultipartFile[] file,HttpServletRequest request) throws IOException { 
		String username=request.getParameter("username");
		request.getSession().setAttribute("username", username);
        for(MultipartFile f : file){     
            //此处MultipartFile[]表明是多文件,如果是单文件MultipartFile就行了  
            if(f.isEmpty()){   
                System.out.println("文件未上传!");  
            }  
            else{  
                //得到上传的文件名  
                String fileName = f.getOriginalFilename();  
                //得到服务器项目发布运行所在地址  
                String path1 = request.getSession().getServletContext().getRealPath("XT21")+File.separator;  
                //  此处未使用UUID来生成唯一标识,用日期做为标识  
                String path = path1+fileName;  
                //查看文件上传路径,方便查找  
                System.out.println(path);  
                //把文件上传至path的路径  
                File localFile = new File(path);  
                f.transferTo(localFile); 
                userService.updateState(username);
                }  
            }  
        return "success";  
    }  
	
	@RequestMapping("empty.do")
	public String emptyState(@RequestParam int page ,Model model){
		userService.emptyState();
		return queryAllByPage(page, model);
		
	}

}
