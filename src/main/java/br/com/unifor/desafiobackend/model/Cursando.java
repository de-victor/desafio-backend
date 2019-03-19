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
@Table(name="cursando")
public class Cursando {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cursando")
	private Long id;
	
	@Column(name="fk_usu_aluno")
	private Long idAluno;
	
	@Column(name="fk_id_curso")
	private Long idCurso;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_curso", insertable=false, updatable=false)
	private Curso curso;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_usu_aluno", insertable=false, updatable=false)
	private Usuario aluno;
	

}
