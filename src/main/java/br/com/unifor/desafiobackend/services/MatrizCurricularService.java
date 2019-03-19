package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.MatrizCurricular;
import br.com.unifor.desafiobackend.repository.MatrizCurricularRepository;

@Service
public class MatrizCurricularService extends GenericService<MatrizCurricular, Long, MatrizCurricularRepository> {

}
