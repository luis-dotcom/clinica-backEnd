package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDto {

	private Long id;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private String sexo;
	private String nomeMae;
	private String naturalidade;
	private String cidade;
	private String bairro;

	public PacienteDto(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.dataNascimento = paciente.getDataNascimento();
		this.telefone = paciente.getTelefone();
		this.email = paciente.getEmail();
		this.cpf = paciente.getCpf();
		this.sexo = paciente.getSexo();
		this.nomeMae = paciente.getNomeMae();
		this.naturalidade = paciente.getNaturalidade();
		this.endereco = paciente.getEndereco();
		this.cidade = paciente.getCidade();
		this.bairro = paciente.getBairro();
	}
}
