package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.TipoUsuario;
import br.com.unifor.desafiobackend.repository.TipoUsuarioRepository;
import br.com.unifor.desafiobackend.services.TipoUsuarioService;

@RestController
@RequestMapping("/usertype")
public class TipoUsuarioController extends GenericControllerCrud<TipoUsuario, Long, TipoUsuarioRepository, TipoUsuarioService> {
	
	


}
