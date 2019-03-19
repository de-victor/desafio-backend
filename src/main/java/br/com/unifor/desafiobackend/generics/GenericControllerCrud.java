package br.com.unifor.desafiobackend.generics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public abstract class GenericControllerCrud<Model, IdType, Repository extends JpaRepository<Model,IdType>, Service extends GenericService<Model, IdType, Repository>> {

	@Autowired
	protected Service service;
	
	@GetMapping
	public List<Model> getAll(){
		return service.getAll();
	}
	
	@PostMapping
	public Model save(@RequestBody Model model) {
		return service.salvar(model);
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable IdType id) {
		service.remover(id);
	}
	
	@PutMapping("/{id}")
	public Model atualizar(@PathVariable Long id, @RequestBody Model model) {
		return service.atualizar(model);
	}
}
