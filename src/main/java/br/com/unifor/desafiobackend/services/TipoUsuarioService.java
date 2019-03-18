package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.TipoUsuario;
import br.com.unifor.desafiobackend.repository.TipoUsuarioRepository;

@Component
@Service
public class TipoUsuarioService extends GenericService<TipoUsuario, Long, TipoUsuarioRepository> {

}
