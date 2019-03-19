package br.com.unifor.desafiobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.generics.GenericControllerCrud;
import br.com.unifor.desafiobackend.model.Cursando;
import br.com.unifor.desafiobackend.repository.CursandoRepository;
import br.com.unifor.desafiobackend.services.CursandoService;

@RestController
@RequestMapping("/cursando")
public class CursandoController extends GenericControllerCrud<Cursando, Long, CursandoRepository, CursandoService> {

}
