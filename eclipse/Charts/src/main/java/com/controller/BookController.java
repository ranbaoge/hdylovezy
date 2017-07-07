package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.Book;
import com.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("save")
	public String save(Model model,Book book){
		bookService.saveBook(book);
		return queryAll(model, 1);
	}
	
	@RequestMapping("update")
	public String update(Model model,Book book){
		bookService.updateBook(book);
		return queryAll(model, 1);
	}
	
	@RequestMapping("delete")
	public String delete(Model model,int id){
		bookService.deleteById(id);
		return queryAll(model, 1);
	}
	
	@RequestMapping("query")
	public String queryAll(Model model,int page){
		int count=bookService.count();
		int pageSize=8;
		int lastPage=count%pageSize==0?count/pageSize:count/pageSize+1;
		
		Map<String, Integer> map=new HashMap<>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<Book> list=bookService.queryByPage(map);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("lastPage", lastPage);
		return "show";
	}
	

	/**
	 * 饼图内容显示
	 * @return
	 */
	@RequestMapping(value="pieCharts",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object pieCharts(){
		Map<String, Object> charts=bookService.pieCharts();
		String json=JSON.toJSONString(charts,true);
		System.out.println(json);
		return json;
	}
	
	
	/**
	 * X-Y坐标图内容显示
	 * @return
	 */
	@RequestMapping(value="charts",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object charts(){
		Map<String, Object> charts=bookService.Charts();
		String json=JSON.toJSONString(charts,true);
		System.out.println(json);
		return json;
	}
	
}
