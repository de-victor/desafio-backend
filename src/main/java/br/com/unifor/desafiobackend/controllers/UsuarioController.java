package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.UsuarioRepository;
import br.com.unifor.desafiobackend.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends GenericControllerCrud<Usuario, Long, UsuarioRepository, UsuarioService> {

}
