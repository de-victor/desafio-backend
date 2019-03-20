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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Long id;
	
	@Column(name="cur_nome")
	private String nome;
	
	@Column(name="cur_fk_id_usu_coordenador")
	private Long idCoordenador;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cur_fk_id_usu_coordenador", insertable=false, updatable=false)
	private Usuario coordenador;
	
}
