package hdy.zy.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hdy.zy.system.entity.Role;
import hdy.zy.system.service.RoleService;

@Controller
@RequestMapping("/System_Role")
public class RoleController {
	@Resource(name="roleService")
	private RoleService roleService;
	private Logger log=Logger.getLogger(RoleController.class);
	
	/**
	 * 新增角色
	 * @param role
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("save.do")
	public String save(Role role,
			           @RequestParam long page,
			           Model model){
		System.out.println(role);
		int rs=roleService.saveRole(role);
		log.info("新增了"+rs+"行");
		return queryByPage(page, model);
	}
	
	/**
	 * 修改角色
	 * @param role
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(Role role,
	           @RequestParam long page,
	           Model model){
		int rs=roleService.updateRole(role);
		log.info("修改了"+rs+"行");
        return queryByPage(page, model);
    }
	
	/**
	 * 删除角色
	 * @param id
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(@RequestParam long id,
			             @RequestParam long page,
			             Model model){
		int rs=roleService.deleteRoleById(id);
		log.info("删除了"+rs+"行");
		return queryByPage(page, model);
	}
	
	/**
	 * 分页查询角色
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("query.do")
	public String queryByPage(@RequestParam long page,
			                  Model model){
		long count =roleService.count();
		long pageSize=8;
		long endPage=count%pageSize==0?count/pageSize:(count/pageSize)+1;
		if(page<=1){
			page=1;
		}
		if(page>endPage){
			page=endPage;
		}
		Map<String, Long> map=new HashMap<String,Long>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<Role> list= roleService.queryAllByPage(map);
		for (Role role : list) {
			System.out.println(role);
		}
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "System_Role/list";
	}
	
	
	
}
