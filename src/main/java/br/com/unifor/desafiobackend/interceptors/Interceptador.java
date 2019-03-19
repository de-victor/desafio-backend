package br.com.unifor.desafiobackend.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.services.UsuarioService;

@Component
public class Interceptador implements HandlerInterceptor {
	@Autowired
	private UsuarioService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(!urlValida(request.getRequestURI(), request.getHeader("token"), request.getMethod()))
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "SEM AUTORIZAÇÃO");

		return true;
	}
	
	private Boolean urlValida(String uri, String token, String method) {
		Usuario usuarioByToken = service.getUsuarioByToken(token);
		return true;
	}
}
