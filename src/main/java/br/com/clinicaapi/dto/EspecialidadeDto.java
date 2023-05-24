package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeDto {

	private Long id;
	private String valor;
	private String verValor;
	
	public EspecialidadeDto(Especialidade especialidade) {
		this.id = especialidade.getId();
		this.valor = especialidade.getValor();
		this.verValor = especialidade.getVerValor();
		
	}
}
