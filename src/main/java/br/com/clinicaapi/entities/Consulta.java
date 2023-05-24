package br.com.clinicaapi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo MATRÍCULA é requerido!")
	private String matricula;
	
	@NotEmpty(message = "Campo NOME ATENDENTE é requerido!")
	private String nomeAtendente;
	
    @NotEmpty(message = "Campo QUEIXAS é requerido!")
	private String queixas;

	@NotEmpty(message = "Campo PLANO é requerido!")
	private String plano;

	@NotEmpty(message = "Campo AVALIAÇÃO é requerido!")
	private String avaliacao;

	private String exames;

	private String encaminhamento;

	private String dataConsulta;
	
	private String observacao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

}