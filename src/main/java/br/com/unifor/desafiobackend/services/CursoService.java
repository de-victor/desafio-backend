package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Curso;
import br.com.unifor.desafiobackend.repository.CursoRepository;

@Component
@Service
public class CursoService extends GenericService<Curso, Long, CursoRepository> {

}
