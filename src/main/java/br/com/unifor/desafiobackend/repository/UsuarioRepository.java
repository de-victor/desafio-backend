package br.com.unifor.desafiobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifor.desafiobackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByToken(String token);
	Usuario findByMatriculaAndSenha(String matricula, String senha);

}
