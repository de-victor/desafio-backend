package br.com.unifor.desafiobackend.interceptors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import br.com.unifor.desafiobackend.configs.TiposUsuarios;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.services.UsuarioService;

@Component
public class Interceptador implements HandlerInterceptor {
	@Autowired
	private UsuarioService service;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(!urlValida(request.getRequestURI(), request.getHeader("token"), request.getMethod()))
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "SEM AUTORIZAÇÃO!");

		return true;
	}
	
	private Boolean urlValida(String uri, String token, String method) {
		Long tipoUsuario;
		
		if(token == null || token.isEmpty())
			tipoUsuario = TiposUsuarios.SEM_IDENTIFICADOR;
		else {
			Usuario usuarioByToken = service.getUsuarioByToken(token);
			if(usuarioByToken == null)
				tipoUsuario = TiposUsuarios.SEM_IDENTIFICADOR;
			else
				tipoUsuario = usuarioByToken.getIdTipo();
		}
		if(!listaUri(tipoUsuario).contains(uri))
			return false;
		
		return true;
	}
	
	private List<String> listaUri(Long tipoUsuario){
		
		Map<Long, List<String>> map = new HashMap<Long, List<String>>();
		map.put(TiposUsuarios.SEM_IDENTIFICADOR, Arrays.asList("/login", "/logout"));
		map.put(TiposUsuarios.ADMINISTRADOR, Arrays.asList("/usuario"));
		map.put(TiposUsuarios.COORDENADOR, Arrays.asList("/curso", "/disciplina", "/semestre", "/matriz"));
		map.put(TiposUsuarios.PROFESSOR, Arrays.asList("/viewmatriz"));
		map.put(TiposUsuarios.ALUNO, Arrays.asList("/viewmatriz"));
		
		
		
		return map.get(tipoUsuario);
	}
}
