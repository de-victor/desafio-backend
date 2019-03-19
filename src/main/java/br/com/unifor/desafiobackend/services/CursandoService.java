package br.com.unifor.desafiobackend.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.unifor.desafiobackend.generics.GenericService;
import br.com.unifor.desafiobackend.model.Cursando;
import br.com.unifor.desafiobackend.repository.CursandoRepository;

@Component
@Service
public class CursandoService extends GenericService<Cursando, Long, CursandoRepository> {

}
