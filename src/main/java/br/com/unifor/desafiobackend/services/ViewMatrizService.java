package br.com.unifor.desafiobackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.model.MatrizCurricular;
import br.com.unifor.desafiobackend.repository.MatrizCurricularRepository;

@Service
public class ViewMatrizService {
	@Autowired
	MatrizCurricularRepository repository;
	
	public List<MatrizCurricular> getAll(){
		List<MatrizCurricular> all = this.repository.findAll();
		
		all.forEach(matriz -> {
			matriz.getCurso().getCoordenador().setIdTipo(null);
			matriz.getCurso().getCoordenador().setMatricula(null);
			matriz.getCurso().getCoordenador().setSenha(null);
			matriz.getCurso().getCoordenador().setToken(null);
			matriz.getCurso().getCoordenador().setTipoUsuario(null);
			
			matriz.getDisciplinas().forEach(item -> {
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
			
			
		});
		
		return all;
	}
}
