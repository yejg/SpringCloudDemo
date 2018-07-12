package com.ye.app.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DemoServiceFallback implements DemoService {

	@Override
	public String sayHello(String userName) {
		return "系统异常，请稍后重试";
	}

	@Override
	public String test1(String userName) {
		return "进入test1-fallback";
	}

	@Override
	public String test2(String userName, int age) {
		return "进入test2-fallback";
	}

	@Override
	public String test3(DemoServiceUser user) {
		return "进入test3-fallback";
	}

	@Override
	public String test33(DemoServiceUser user) {
		return "进入test33-fallback";
	}

	@Override
	public String test4(Map<String,Object> userMap) {
		return "进入test4-fallback";
	}

	@Override
	public String test5(Map<String,Object> userMap, String address) {
		return "进入test5-fallback";
	}

}
