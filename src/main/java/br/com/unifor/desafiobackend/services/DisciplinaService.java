package br.com.unifor.desafiobackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Disciplina;
import br.com.unifor.desafiobackend.model.Usuario;
import br.com.unifor.desafiobackend.repository.DisciplinaRepository;

@Service
public class DisciplinaService extends GenericService<Disciplina, Long, DisciplinaRepository> {
	@Autowired
	UsuarioService userService;
	
	@Override
	public Disciplina salvar(Disciplina model) {
		Usuario professor = userService.getById(model.getIdProfessor());
		if(professor == null || professor.getIdTipo() != 3)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PROFESSOR INVALIDO INVALIDO");
		
		return super.salvar(model);
	}
	
	@Override
	public List<Disciplina> getAll() {
		List<Disciplina> all = super.getAll();
		
		all.forEach(item -> {
			//removendo dados de professor
			item.getProfessor().setIdTipo(null);
			item.getProfessor().setMatricula(null);
			item.getProfessor().setIdTipo(null);
			item.getProfessor().setSenha(null);
			item.getProfessor().setTipoUsuario(null);
			item.getProfessor().setToken(null);
			
			//removendo dados de coordenador
			item.getCurso().getCoordenador().setIdTipo(null);
			item.getCurso().getCoordenador().setMatricula(null);
			item.getCurso().getCoordenador().setIdTipo(null);
			item.getCurso().getCoordenador().setSenha(null);
			item.getCurso().getCoordenador().setTipoUsuario(null);
			item.getCurso().getCoordenador().setToken(null);
		});
		
		return all;
	}

}
