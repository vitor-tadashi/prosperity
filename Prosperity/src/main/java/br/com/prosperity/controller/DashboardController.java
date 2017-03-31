package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	@RequestMapping(value = "/pagina-inicial")
	public String indexLogin() {
		return "dashboard/pagina-inicial";
	}
}
