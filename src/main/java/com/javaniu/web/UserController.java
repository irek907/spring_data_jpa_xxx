package com.javaniu.web;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaniu.domain.User;
import com.javaniu.repository.UserRepository;
import com.javaniu.utils.ResultBean;

@Controller
@RequestMapping({ "/user" })
public class UserController {
	@Autowired
	UserRepository repository;

	@RequestMapping(value = { "list" })
	public @ResponseBody
	JSONObject index() {
		JSONObject json = new JSONObject();
		List<User> users = repository.findAll();
		json.put("data", users);
		return json;
	}
	@RequestMapping(value = { "login" })
	public @ResponseBody
	JSONObject login(@Param("username")String userName,@Param("password")String password) {
		JSONObject json = new JSONObject();
		List<User> users = repository.findByUserName(userName);
		ResultBean rBean = new ResultBean();
		if(users!=null){
			if(password.equals(users.get(0))){
				rBean.setMsg("ok");
				rBean.setStatus("0");
			}else{
				rBean.setMsg("error");
				rBean.setStatus("1");
			}
		}else{
			rBean.setMsg("null");
			rBean.setStatus("1");
		}
		
		
		json.put("data", rBean);
		return json;
	}

}
