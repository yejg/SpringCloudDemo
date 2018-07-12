package com.ye.app.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ye.app.form.User;

@RestController
@RequestMapping("/demo-service")
public class DemoAction {

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/hello/{userName}")
	public String sayHello(@PathVariable String userName) {
		return "hello, " + userName;
	}

	@RequestMapping("/test1")
	public String test1(String userName) throws InterruptedException {
		logger.info("进入test1，即将sleep3秒");
		Thread.sleep(3000);
		return "[test1]userName, " + userName;
	}

	@RequestMapping("/test2")
	public String test2(String userName, int age) {
		return "[test2]userName=" + userName + ", age=" + age;
	}

	@RequestMapping("/test3")
	public String test3(@RequestBody(required = false) User user, HttpServletRequest request) {
		Map<String, Object> tmp = this.getParametersFromRequest(request);
		logger.info("[test3]接收到的参数为[{}]", tmp);
		return "[test3]userName=" + user.getUserName() + ", age=" + user.getAge();
	}
	
	// test3 升级版   feign调用时通过拦截器把json body转成query
	@RequestMapping("/test33")
	public String test33(User user, HttpServletRequest request) {
		Map<String, Object> tmp = this.getParametersFromRequest(request);
		logger.info("[test3]接收到的参数为[{}]", tmp);
		return "[test3]userName=" + user.getUserName() + ", age=" + user.getAge();
	}

	@RequestMapping("/test4")
	public String test4(HttpServletRequest request) {
		Map<String, Object> tmp = this.getParametersFromRequest(request);
		logger.info("接收到的参数为[{}]", tmp);
		return "[test4]" + tmp;
	}

	@RequestMapping("/test5")
	public String test5(HttpServletRequest request, String address) {
		Map<String, Object> tmp = this.getParametersFromRequest(request);
		logger.info("接收到的参数address={}", address);
		logger.info("接收到的参数为[{}]", tmp);
		return "[test5]" + tmp;
	}

	protected Map<String, Object> getParametersFromRequest(HttpServletRequest request) {
		Map<String, String[]> params = request.getParameterMap();

		Map<String, Object> tmp = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> iterator = params.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String[]> entry = iterator.next();
			String key = (String) entry.getKey();
			String[] value = entry.getValue();

			String tmpKey = key;
			Object tmpValue = value;

			if (value != null && value.length == 1) {
				tmpValue = value[0];
			}

			tmp.put(tmpKey, tmpValue);
		}
		return tmp;
	}

}
