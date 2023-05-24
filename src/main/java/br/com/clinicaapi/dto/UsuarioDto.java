package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

	private Long id;
	private String matricula;
	private String nome;
	private String tipoPerfil;
	private String cpf;
	private String endereco;
	private String email;
	private String senha;

	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.matricula = usuario.getMatricula();
		this.nome = usuario.getNome();
		this.tipoPerfil = usuario.getTipoPerfil();
		this.cpf = usuario.getCpf();
		this.endereco = usuario.getEndereco();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
}
