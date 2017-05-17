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

import hdy.zy.system.entity.Department;
import hdy.zy.system.service.DepartmentService;

@Controller
@RequestMapping("System_Department")
public class DepartmentController {
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private Logger log=Logger.getLogger(DepartmentController.class);
	
	/**
	 * 新增部门
	 * @param role
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("save.do")
	public String save(Department department,
			           @RequestParam long page,
			           Model model){
		System.out.println(department);
		int rs=departmentService.saveDepartment(department);
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
	public String update(Department department,
	           @RequestParam long page,
	           Model model){
		System.out.println(department);
		int rs=departmentService.updateDepartment(department);
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
		int rs=departmentService.deleteDepartmentById(id);
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
		long count =departmentService.count();
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
		List<Department> list=departmentService.queryAllByPage(map);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "System_Department/list";
	}
	
}
