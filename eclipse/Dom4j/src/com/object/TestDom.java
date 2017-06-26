package com.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class TestDom {

	@Test
	public void before() throws Exception{
		//创建SAXReader对象
		SAXReader reader=new SAXReader();
		//读取文件，转换成Document
		Document document=reader.read(new File("src/class.xml"));
		//获取根节点元素
		Element root=document.getRootElement();
		queryAllNodes(root);
	}
	
	/**
	 * 遍历所有根节点
	 */
	public void queryAllNodes(Element node){
		System.out.println("当前节点名称:"+node.getName());
		//获取根节点下所有属性节点
		@SuppressWarnings("unchecked")
		List<Attribute> list=node.attributes();
		//遍历属性节点
		for (Attribute a : list) {
			System.out.println("属性"+a.getName()+":"+a.getValue());
		}
		
		//判断当前节点内容不为空就输出
		if(!"".equals(node.getTextTrim())){
			System.out.println(node.getName()+":"+node.getText());
		}
		
		//迭代输出当前节点下的所有子节点
		//使用递归
		@SuppressWarnings("unchecked")
		Iterator<Element> it=node.elementIterator();
		while (it.hasNext()) {
			Element e=it.next();
			queryAllNodes(e);
		}
	}
	
	/**
	 * 增加dom节点和属性
	 * @throws Exception 
	 */
	@Test
	public void insertDom() throws Exception{
		//创建SAXReader对象
		SAXReader reader=new SAXReader();
		//读取文件，转换成Document
		Document document=reader.read(new File("src/class.xml"));
		//获取根节点元素
		Element root=document.getRootElement();
		
		System.out.println("-------------添加节点之前-----------------");
		@SuppressWarnings("unchecked")
		List<Element> list=root.elements("class");
		queryAllNodes(list.get(0));
		
		//删除属性
		Attribute id=list.get(0).attribute("id");
		list.get(0).remove(id);
		
		//删除节点
		Element element=list.get(0).element("teacher");
		list.get(0).remove(element);
		
		//添加新的节点
		list.get(0).addElement("hr");
		list.get(0).element("hr").setText("您好啊");
		
		//添加属性
		list.get(0).addAttribute("name", "hello,dom4j");
		
		System.out.println("-------------删除后添加属性--------");
		
		queryAllNodes(list.get(0));
	}
	
	/**
	 * 写入新文件
	 * @throws Exception 
	 */
	@Test
	public void writeDom() throws Exception{
		//创建SAXReader对象
				SAXReader reader=new SAXReader();
				//读取文件，转换成Document
				Document document=reader.read(new File("src/class.xml"));
				//获取根节点元素
				Element root=document.getRootElement();
				
				System.out.println("-------------添加节点之前-----------------");
				@SuppressWarnings("unchecked")
				List<Element> list=root.elements("class");
				queryAllNodes(list.get(0));
				
				//删除属性
				Attribute id=list.get(0).attribute("id");
				list.get(0).remove(id);
				
				//删除节点
				Element element=list.get(0).element("teacher");
				list.get(0).remove(element);
				
				//添加新的节点
				list.get(0).addElement("hr");
				list.get(0).element("hr").setText("您好啊");
				
				//添加属性
				list.get(0).addAttribute("name", "hello,dom4j");
				
				System.out.println("-------------删除后添加属性--------");
				
				queryAllNodes(list.get(0));
				
				//输出格式
				OutputFormat format=OutputFormat.createPrettyPrint();
				//设置编码
				format.setEncoding("utf-8");
				//指定输出文件以及格式
				XMLWriter writer=new XMLWriter(new FileOutputStream(new File("src/class2.xml")), format);
				writer.write(root);
				writer.flush();
				writer.close();
	}
	
}
