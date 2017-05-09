package com.fkb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping({ "/error" })
public class ErrorController {
	@RequestMapping(value = { "" })
	public @ResponseBody
	ModelAndView error() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error");
		return mv;
	}
}
