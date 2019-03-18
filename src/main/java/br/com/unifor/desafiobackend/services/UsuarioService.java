package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.UsuarioRepository;

@Component
@Service
public class UsuarioService extends GenericService<Usuario, Long, UsuarioRepository> {

}
