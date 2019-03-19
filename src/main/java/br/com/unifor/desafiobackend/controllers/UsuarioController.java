package br.com.unifor.desafiobackend.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.UsuarioRepository;
import br.com.unifor.desafiobackend.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericControllerCrud<Usuario, Long, UsuarioRepository, UsuarioService> {
	
	@PostMapping("/login")
	public Usuario login(@RequestBody Usuario usuario) {
		return this.service.login(usuario);
	}
	
	@PostMapping("/logout")
	public Map<String, String> logout(@RequestBody Usuario usuario) {
		this.service.logout(usuario);
		HashMap<String, String> resposta = new HashMap<String,String>();
		resposta.put("codigo", "200");
		resposta.put("msg", "Desconectado com sucesso!");
		return resposta;
	}

}
