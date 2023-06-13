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

import org.hibernate.validator.constraints.Length;

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
	
	@Length(min = 0, max = 1000)
    private String queixas;

    @Length(min = 0, max = 1000)
	private String plano;

	@Length(min = 0, max = 1000)
	private String avaliacao;

	@Length(min = 0, max = 1000)
	private String exames;

	@Length(min = 0, max = 1000)
	private String encaminhamento;
    
	@NotEmpty(message = "Campo DATA é requerido!")
	private String dataConsulta;
	
	@Length(min = 0, max = 1000, message = "O Campo Observação deve ter entre 0 e 1000 caracteres.")
	private String observacao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

}