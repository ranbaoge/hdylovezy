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
import com.entity.Charts;
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
	
	@RequestMapping(value="chart01",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart01(){
		
		Charts chart = bookService.chart01();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart02",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart02(){
		Charts chart = bookService.chart02();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart03",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart03(){
		Charts chart = bookService.chart03();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart04",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart04(){
		Charts chart = bookService.chart04();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart05",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart05(){
		Charts chart = bookService.chart05();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart06",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart06(){
		Charts chart = bookService.chart06();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart07",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart07(){
		Charts chart = bookService.chart07();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart08",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart08(){
		Charts chart = bookService.chart08();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
	
	@RequestMapping(value="chart09",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object chart09(){
		Charts chart = bookService.chart09();
		String json=JSON.toJSONString(chart, true);
		return json;
	}
}
