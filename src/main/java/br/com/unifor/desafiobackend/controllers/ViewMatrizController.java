package br.com.unifor.desafiobackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifor.desafiobackend.model.MatrizCurricular;
import br.com.unifor.desafiobackend.services.ViewMatrizService;

@RestController
@RequestMapping("/viewmatriz")
public class ViewMatrizController {
	@Autowired
	ViewMatrizService service;
	
	@GetMapping
	public List<MatrizCurricular> getAll(){
		return this.service.getAll(); 
	}
}
