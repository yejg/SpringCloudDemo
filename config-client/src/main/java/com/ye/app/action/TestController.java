package com.ye.app.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

	@Autowired
	private ConfigProp prop;

	@Value("${test.key1}")
	private String from;

	@RequestMapping(value= "/from",method=RequestMethod.POST)
	public String from() {
		System.out.println("------------------请求到了from------------------");
		return this.from + "\t" + prop.getKey1() + "\t" + prop.getKey2();
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return from;
	}

}