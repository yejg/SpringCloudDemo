package com.ye.app.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ye.app.model.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users") // 通过这里配置使下面的映射都在/users下，可去除
public class UserAction {

	static Map<Long, User> usersMap = Collections.synchronizedMap(new HashMap<Long, User>());

	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(usersMap.values());
		return r;
	}

	// 参考 http://blog.didispace.com/springbootswagger2/
	// 通过@ApiOperation注解来给API增加说明
	// 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		usersMap.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return usersMap.get(id);
	}

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		User u = usersMap.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		usersMap.put(id, u);
		return "success";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		usersMap.remove(id);
		return "success";
	}

}
