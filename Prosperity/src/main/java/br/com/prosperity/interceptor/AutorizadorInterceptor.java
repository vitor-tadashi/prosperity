package br.com.prosperity.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		
		String uri = request.getRequestURI();
	      if(uri.endsWith("login/") || 
	          uri.endsWith("/autenticar") || 
	              uri.contains("resources") || uri.contains("resources/img")){
	        return true;
	      }
		
		if (request.getSession().getAttribute("autenticado") != null) {
			request.setAttribute("autenticado", request.getSession().getAttribute("autenticado"));
			return true;
		}else{
		response.sendRedirect(request.getContextPath() + "/login/");
		return false;
		}
	}
}
