package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Disciplina;
import br.com.unifor.desafiobackend.repository.DisciplinaRepository;
import br.com.unifor.desafiobackend.services.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController extends GenericControllerCrud<Disciplina, Long, DisciplinaRepository, DisciplinaService> {

}
