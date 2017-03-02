package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VagaController {
	@RequestMapping(value ="/teste", method = RequestMethod.GET)
	public ModelAndView cliente() {
		return new ModelAndView("teste");
	}
}
