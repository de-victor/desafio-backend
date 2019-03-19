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
	
	@Column(name="cur_carga_horaria")
	private Integer cargaHoraria;
	
	@Column(name="fk_id_usu_professor")
	private Long idProfessor;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_usu_professor", insertable=false, updatable=false)
	private Usuario professor;
	
}
