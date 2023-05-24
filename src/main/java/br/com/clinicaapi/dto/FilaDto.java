package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Fila;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilaDto {

	private Long id;

	private String nome;
	private String sala;

	public FilaDto(Fila fila) {
		this.id = fila.getId();
		this.nome = fila.getNome();
		this.sala = fila.getSala();
	}
}
