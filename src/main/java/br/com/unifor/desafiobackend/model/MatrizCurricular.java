package br.com.unifor.desafiobackend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="matriz_curricular")
public class MatrizCurricular {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_matriz_cur")
	private Long id;
	
	@Column(name="matri_fk_id_sem")
	private Long idSemestre;
	
	@Column(name="matri_fk_id_dis")
	private Long idDisciplina;
	
	@Column(name="matri_fk_id_curso")
	private Long idCurso;
	
	@OneToOne
	@JoinColumn(name="matri_fk_id_curso", insertable=false, updatable=false)
	private Curso curso;
	
	@OneToOne
	@JoinColumn(name="matri_fk_id_sem", insertable=false, updatable=false)
	private Semestre semestre;
	
	@OneToMany
	@JoinColumn(name="id_disciplina", insertable=false, updatable=false)
	private List<Disciplina> disciplinas;
	
	
	
}
