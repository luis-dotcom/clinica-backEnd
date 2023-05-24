package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDto {

	private Long id;
	private String matricula;
	private String nome;
	private String tipoPerfil;
	private String cpf;
	private String endereco;
	private String email;
	private String senha;
	private String curso;

	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.matricula = aluno.getMatricula();
		this.nome = aluno.getNome();
		this.tipoPerfil = aluno.getTipoPerfil();
		this.cpf = aluno.getCpf();
		this.endereco = aluno.getEndereco();
		this.email = aluno.getEmail();
		this.senha = aluno.getSenha();
		this.curso = aluno.getCurso();
	}
}
