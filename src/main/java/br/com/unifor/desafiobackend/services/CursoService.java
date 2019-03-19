package br.com.unifor.desafiobackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Curso;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.CursoRepository;

@Component
@Service
public class CursoService extends GenericService<Curso, Long, CursoRepository> {
	@Autowired
	UsuarioService userService;
	
	@Override
	public Curso salvar(Curso model) {
		Usuario coordenador = userService.getById(model.getIdCoordenador());
		
		if(coordenador.getIdTipo() != 2)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "COORDENADOR DE CURSO INVALIDO");
		
		return this.repository.saveAndFlush(model);
	}
	
	@Override
	public List<Curso> getAll() {
		List<Curso> all = super.getAll();
		all.forEach(item -> {
			item.getCoordenador().setSenha(null);
			item.getCoordenador().setToken(null);
			item.getCoordenador().setMatricula(null);
			item.getCoordenador().setIdTipo(null);
			item.getCoordenador().setTipoUsuario(null);
		});
		return all;
	}

}
