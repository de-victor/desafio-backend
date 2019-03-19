package br.com.unifor.desafiobackend.generics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public abstract class GenericService<Model, IdType, Repository extends JpaRepository<Model, IdType>> {
	
	@Autowired
	protected Repository repository;
	
	public List<Model> getAll(){
		return repository.findAll();
	}
	
	public void remover(IdType id) {
		repository.deleteById(id);
	}
	
	public Model salvar(Model model) {
		return repository.saveAndFlush(model);
	}
	
	public Model getById(IdType id) {
		return repository.getOne(id);
	}
	
	public Model atualizar(Model model) {
		return repository.saveAndFlush(model);
	}
	
}
