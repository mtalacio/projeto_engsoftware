package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("login") 
				|| uri.endsWith("efetuaLogin")
				|| uri.endsWith("/")
				|| uri.endsWith("perfil")
				|| uri.endsWith("pesquisa")) {
			
			return true;
		}
		
		if(request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		
		response.sendRedirect("login");
		return false;
	}
}
