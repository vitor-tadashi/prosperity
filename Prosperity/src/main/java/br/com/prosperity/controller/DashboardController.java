package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "pagina-inicial")
public class DashboardController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexLogin() {
		return "dashboard/pagina-inicial";
	}
}
