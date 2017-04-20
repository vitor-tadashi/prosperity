package br.com.prosperity.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.FuncionalidadeBusiness;
import br.com.prosperity.business.PerfilBusiness;

@Component
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private FuncionalidadeBusiness funcionalidadeBusiness;

	@Autowired
	private PerfilBusiness perfilBusiness;
	
	@Autowired
	public UsuarioBean user;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		String uri = request.getRequestURI();
		
	      if(uri.endsWith("login/") || 
	          uri.endsWith("/autenticar") || 
	              uri.contains("resources/") || uri.endsWith("/servico")){
	        return true;
	      }
	      
		if (request.getSession().getAttribute("autenticado") != null) {
			request.setAttribute("autenticado", request.getSession().getAttribute("autenticado"));
			user = (UsuarioBean) request.getSession().getAttribute("autenticado");
			
/*			List<FuncionalidadeBean> funcionalidades = new ArrayList<>();
			
			if(request.getSession().getAttribute("funcionalidades") == null) {
				funcionalidades = funcionalidadeBusiness.listar();
				perfilBusiness.obterPerfilFuncionalidades(user.getPerfil().getId());
				request.getSession().setAttribute("funcionalidades", funcionalidades);
			}*/
			
			//funcionalidades = (List<FuncionalidadeBean>) request.getSession().getAttribute("funcionalidades");
			
			for(FuncionalidadeBean fun : funcionalidadeBusiness.listar()){
				if(uri.endsWith(fun.getUrl())){
					for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
						if(f.getId() == fun.getId()){
							return true;
						}
					}
					response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
					return false;
				}
			}
			
			/*if(uri.endsWith("usuario/criar-perfil")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 16){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("vaga/aprovar")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 1){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("vaga/solicitar")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 3){
						return true;
					}
				}
			response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("vaga/consultar")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 2 ){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("usuario/listar")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 22){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("candidato/cadastrar")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 17){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("candidato/consultar-gestor")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 19){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("candidato/consultar-rh")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 20){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}
			if(uri.endsWith("candidato/historico")){
				for(FuncionalidadeBean f : user.getPerfil().getListaFuncionalidades()){
					if(f.getId() == 18){
						return true;
					}
				}
				response.sendRedirect(request.getContextPath() + "/pagina-inicial/");
				return false;
			}*/
			
			return true;
			//return false;
		}else{
		response.sendRedirect(request.getContextPath() + "/login/");
		return false;
		}
	}
}
