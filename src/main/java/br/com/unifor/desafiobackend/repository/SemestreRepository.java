package br.com.unifor.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifor.desafiobackend.model.Semestre;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {

}
