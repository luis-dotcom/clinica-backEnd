package br.com.clinicaapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Campo NOME é requerido!")
    private String nome;

	@NotEmpty(message = "Campo DATA DE NASCIMENTO é requerido!")
	private String dataNascimento;

	@NotEmpty(message = "Campo TELEFONE é requerido!")
	private String telefone;

	private String email;

	@NotEmpty(message = "Campo CPF é requerido!")
	@Length(min = 11, max = 11)
	private String cpf;

	@NotEmpty(message = "Campo SEXO é requerido!")
	private String sexo;

	@NotEmpty(message = "Campo NOME DA MÃE é requerido!")
	private String nomeMae;

	@NotEmpty(message = "Campo NATURALIDADE é requerido!")
	private String naturalidade;

	@NotEmpty(message = "Campo ENDEREÇO é requerido!")
	private String endereco;
	
	@NotEmpty(message = "Campo CIDADE é requerido!")
	private String cidade;

	private int idade;

	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas = new ArrayList<>();

	public Paciente(Long id, String nome, String dataNascimento, String telefone, String email, String cpf, String sexo,
			String nomeMae, String naturalidade, String endereco, String cidade, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.sexo = sexo;
		this.nomeMae = nomeMae;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
		this.cidade = cidade;
		this.idade = idade;
	}

}
