package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Curso;
import br.com.unifor.desafiobackend.repository.CursoRepository;
import br.com.unifor.desafiobackend.services.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController extends GenericControllerCrud<Curso, Long, CursoRepository, CursoService> {

}
