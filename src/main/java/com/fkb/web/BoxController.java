package com.fkb.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fkb.domain.Box;
import com.fkb.repository.BoxRepository;
import com.fkb.utils.ResultBean;

import net.sf.json.JSONObject;

@Controller
@RequestMapping({ "/box" })
public class BoxController {
	@Autowired
	BoxRepository repository;
	@RequestMapping(value = { "list" })
	public @ResponseBody
	JSONObject list() {
		JSONObject json = new JSONObject();
		List<Box> boxs = repository.findAll();
		json.put("data", boxs);
		return json;
	}
	
	@RequestMapping(value = {"openbox"})
	public @ResponseBody
	JSONObject openBox(String id,String cmd){
		Box box = repository.findOne(Long.parseLong(id));
		box.setOpen(cmd);
		Box bx = repository.save(box);
		ResultBean rBean = new ResultBean();
		rBean.setType("2");
		JSONObject json = new JSONObject();
		if(bx!=null){
			rBean.setStatus("0");
			rBean.setMsg("1".equals(cmd)?"关锁成功！":"开锁成功！");
		}else{
			rBean.setStatus("1");
			rBean.setMsg("开锁失败！");
		}
		json.put("data", rBean);
		return json;
	}

	@RequestMapping(value = {"create"})
	public @ResponseBody
	JSONObject create(String sn,String address,String time,String temperature,String humidity,String open){
		
		Box b = new Box();
		
		b.setSn(sn);
		b.setAddress(address);
		b.setTime(time);
		b.setTemperature(temperature);
		b.setHumidity(humidity);
		b.setOpen("0");
		
		Box bx  = repository.save(b);
		
		
		ResultBean rBean = new ResultBean();
		rBean.setType("3");
		JSONObject json = new JSONObject();
		if(bx!=null){
			rBean.setStatus("0");
			rBean.setMsg("插入成功！");
		}else{
			rBean.setStatus("1");
			rBean.setMsg("插入失败！");
		}
		json.put("data", rBean);
		return json;
	}
	
	@RequestMapping(value = {"searchbox"})
	public @ResponseBody
	JSONObject searchbox(String sn){
		Box box = repository.findBySn(sn);
		ResultBean rBean = new ResultBean();
		rBean.setType("1");
		JSONObject json = new JSONObject();
		if(box!=null){
			List<Box> lb = new ArrayList<Box>();
			lb.add(box);
			rBean.setData(lb);
			rBean.setStatus("0");
			rBean.setMsg("查询成功！");
		}else{
			rBean.setStatus("1");
			List<Box> lb = new ArrayList<Box>();
			Box box2 = new Box();
			lb.add(box2);
			rBean.setData(lb);
			rBean.setMsg("改箱子不存在！");
		}
		json.put("data", rBean);
		return json;
	}
}
