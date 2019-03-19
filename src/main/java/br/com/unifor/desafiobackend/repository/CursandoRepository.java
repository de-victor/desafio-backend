package br.com.unifor.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifor.desafiobackend.model.Cursando;

public interface CursandoRepository extends JpaRepository<Cursando, Long> {

}
