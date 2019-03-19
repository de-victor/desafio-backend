package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Semestre;
import br.com.unifor.desafiobackend.repository.SemestreRepository;
import br.com.unifor.desafiobackend.services.SemestreService;

@RestController
@RequestMapping("/semestre")
public class SemestreController extends GenericControllerCrud<Semestre, Long, SemestreRepository, SemestreService> {

}
