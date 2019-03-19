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
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="disciplina")
public class Disciplina {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_disciplina")
	private Long id;
	
	@Column(name="dis_fk_id_curso")
	@NotNull(message="Curso é obrigatorio!")
	private Long idCurso;
	
	@Column(name="dis_fk_id_usu_professor")
	@NotNull(message="Professor é obrigatorio!")
	private Long idProfessor;
	
	@Column(name="dis_carga_horaria")
	@NotNull(message="Carga horaria é obrigatoria!")
	private Integer cargaHoraria;
	
	@Column(name="dis_nome")
	@NotBlank(message = "Nome é obritatorio!")
	private String nome;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dis_fk_id_usu_professor", insertable=false, updatable=false)
	private Usuario professor;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dis_fk_id_curso", insertable=false, updatable=false)
	private Curso curso;

}
