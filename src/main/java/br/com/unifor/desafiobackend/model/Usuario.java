package br.com.unifor.desafiobackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="usu_matricula")
	private String matricula;
	
	@Column(name="usu_nome")
	private String nome;
	
	@Column(name="usu_senha")
	private String senha;
	
	@Column(name="fk_tipo_usu")
	private Long idTipo;
	
	//private TipoUsuario tipoUsuario;
	
	
	
	

}
