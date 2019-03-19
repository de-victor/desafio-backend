package br.com.unifor.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifor.desafiobackend.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
