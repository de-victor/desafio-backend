package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.MatrizCurricular;
import br.com.unifor.desafiobackend.repository.MatrizCurricularRepository;
import br.com.unifor.desafiobackend.services.MatrizCurricularService;

@RestController
@RequestMapping("/matriz")
public class MatrizCurricularController extends GenericControllerCrud<MatrizCurricular, Long, MatrizCurricularRepository, MatrizCurricularService> {

}
