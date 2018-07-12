package com.ye.app.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "demo-service", fallback = DemoServiceFallback.class)
public interface DemoService {

	@RequestMapping("/demo-service/hello/{userName}")
	public String sayHello(@PathVariable("userName") String userName);

	@RequestMapping("/demo-service/test1")
	public String test1(@RequestParam(value = "userName") String userName);
	
	@RequestMapping("/demo-service/test2")
	public String test2(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "age") int age);
	
	@RequestMapping(value = "/demo-service/test3", method = RequestMethod.POST)
	public String test3(@RequestBody(required = false) DemoServiceUser user);
	
	@RequestMapping(value = "/demo-service/test33", method = RequestMethod.GET)
	public String test33(@RequestBody DemoServiceUser user);
	
	@RequestMapping("/demo-service/test4")
	public String test4(@RequestParam Map<String,Object> userMap);
	
	@RequestMapping("/demo-service/test5")
	public String test5(@RequestParam Map<String,Object> userMap, @RequestParam(value = "address") String address);
	
}
