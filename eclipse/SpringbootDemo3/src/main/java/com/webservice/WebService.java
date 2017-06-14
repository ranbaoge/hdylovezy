package com.webservice;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Teacher;
import com.service.TeacherService;

@javax.jws.WebService(endpointInterface="com.service.TeacherService")
@Component("webService")
public class WebService {

	@Autowired
	private TeacherService teacherService;
	
	public void queryAll(){
		List<Teacher> list=teacherService.queryAll();
		for (Teacher t : list) {
			System.out.println(t);
		}
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://192.168.0.82:8088/Service/query", new WebService());
	}
}
