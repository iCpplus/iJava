package edu.zut.cs.software.base.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author shishuqian
 *
 */
@Controller
@RequestMapping("/error")
public class HandleError {

	@RequestMapping(value = "400", method = RequestMethod.GET)
	public ModelAndView error_400(ModelMap modelMap) {
		modelMap.put("errorMessage", "400&nbsp;&nbsp;出错了!");
		return new ModelAndView("commons/error", modelMap);
	}

	@RequestMapping(value = "404", method = RequestMethod.GET)
	public ModelAndView error_404(ModelMap modelMap) {
		modelMap.put("errorMessage", "404&nbsp;&nbsp;找不到家了!");
		return new ModelAndView("commons/error", modelMap);
	}

	@RequestMapping(value = "500", method = RequestMethod.GET)
	public ModelAndView error_500(ModelMap modelMap) {
		modelMap.put("errorMessage", "500&nbsp;&nbsp;出错了!");
		return new ModelAndView("commons/error", modelMap);
	}

}
