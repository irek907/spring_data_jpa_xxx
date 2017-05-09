package com.fkb.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object arg2,
			Exception ex) {
		// TODO Auto-generated method stub
		
		ResultBean rBean = new ResultBean();
		rBean.setStatus("1");
		rBean.setMsg(ex.getMessage());
		JSONObject json = new JSONObject();
		json.put("data", rBean);
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex1", json);  
        request.setAttribute("ex", json.toString()); 
        return new ModelAndView("error", model); 
	}

}
