package br.com.unifor.desafiobackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_usu")
	private Long id;
	
	@Column(name="tip_descricao", nullable = false, length = 20)
	@NotBlank(message = "Descrição do tipo usuario é obritatoria!")
	private String descricao;

}
