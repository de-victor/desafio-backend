package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Semestre;
import br.com.unifor.desafiobackend.repository.SemestreRepository;

@Service
public class SemestreService extends GenericService<Semestre, Long, SemestreRepository> {

}
