package br.com.unifor.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifor.desafiobackend.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
