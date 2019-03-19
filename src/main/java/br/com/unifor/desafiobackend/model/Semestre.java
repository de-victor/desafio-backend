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
@Table(name="semestre")
public class Semestre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_semestre")
	private Long id;
	
	@Column(name="sem_ano")
	private String ano;
	
	@Column(name="sem_perido")
	private String periodo;

}
