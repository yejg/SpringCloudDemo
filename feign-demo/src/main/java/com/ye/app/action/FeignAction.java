package com.ye.app.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ye.app.service.DemoService;
import com.ye.app.service.DemoServiceUser;


@RestController
@RequestMapping("/feign-demo")
public class FeignAction {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/getStatus")
	public String getStatus() {
		return "ok";
	}
	
	@RequestMapping("/callDemoService")
	public String callDemoService(String userName) {
		return demoService.sayHello(userName);
	}
	
	@RequestMapping("/callTest1")
	public String callTest1(String userName) {
		return demoService.test1(userName);
	}
	
	@RequestMapping("/callTest2")
	public String callTest2(String userName, int age) {
		return demoService.test2(userName, age);
	}
	
	@RequestMapping("/callTest3")
	public String callTest3(DemoServiceUser user) {
		// 目前Feign当POST一个null时，会报异常）
		// https://github.com/spring-cloud/spring-cloud-netflix/issues/1047
		return demoService.test3(user);
	}
	
	@RequestMapping("/callTest33")
	public String callTest33(DemoServiceUser user) {
		return demoService.test33(user);
	}
	
	@RequestMapping("/callTest4")
	public String callTest4(String userName, int age) {
		Map<String,Object> userMap = new HashMap<>();
		userMap.put("userName", userName);
		userMap.put("age", age);
		return demoService.test4(userMap);
	}
	
	@RequestMapping("/callTest5")
	public String callTest5(String userName, int age) {
		Map<String,Object> userMap = new HashMap<>();
		userMap.put("userName", userName);
		userMap.put("age", age);
		return demoService.test5(userMap, "武汉");
	}
}
