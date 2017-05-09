package com.fkb.web;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fkb.domain.User;
import com.fkb.repository.UserRepository;
import com.fkb.utils.ResultBean;

@Controller
@RequestMapping({ "/user" })
public class UserController {
	@Autowired
	UserRepository repository;

	@RequestMapping(value = { "list" })
	public @ResponseBody
	JSONObject list() {
		JSONObject json = new JSONObject();
		//System.out.println(1/0);
		//System.out.println("--");
		List<User> users = repository.findAll();
		json.put("data", users);
		return json;
	}
	@RequestMapping(value = { "login" })
	public @ResponseBody
	JSONObject login(@Param("userName")String userName,@Param("password")String password) {
		JSONObject json = new JSONObject();
		List<User> users = repository.findByUserName(userName);
		ResultBean rBean = new ResultBean();
		if(users.size()!=0){
			if(password.equals(users.get(0).getPassword())){
				rBean.setMsg("认证成功！");
				rBean.setStatus("0");
			}else{
				rBean.setMsg("密码错误！");
				rBean.setStatus("1");
			}
		}else{
			rBean.setMsg("账号不存在！");
			rBean.setStatus("1");
		}
		json.put("data", rBean);
		return json;
	}
	
	@RequestMapping(value = { "register" })
	public @ResponseBody
	JSONObject register(@Param("userName")String userName,@Param("password")String password) {
		JSONObject json = new JSONObject();
		List<User> users = repository.findByUserName(userName);
		ResultBean rBean = new ResultBean();
		if(users.size()!=0){
			rBean.setMsg("该账号已存在！");
			rBean.setStatus("1");
		}else{
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			User u = repository.save(user);
			if(u!=null){
				rBean.setMsg("注册成功！");
				rBean.setStatus("0");
			}else
			{
				rBean.setMsg("注册失败！");
				rBean.setStatus("1");
			}
		}
		json.put("data", rBean);
		return json;
	}

}
