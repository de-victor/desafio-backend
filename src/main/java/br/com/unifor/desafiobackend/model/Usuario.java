package br.com.unifor.desafiobackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="usu_matricula")
	private String matricula;
	
	@Column(name="usu_nome")
	@NotBlank(message = "Descrição do tipo usuario é obritatoria!")
	private String nome;
	
	@Column(name="usu_senha")
	private String senha;
	
	@Column(name="usu_fk_tipo_usu")
	private Long idTipo;
	
	@Column(name="usu_token")
	private String token;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="usu_fk_tipo_usu", insertable=false, updatable=false)
	private TipoUsuario tipoUsuario;
	
}
