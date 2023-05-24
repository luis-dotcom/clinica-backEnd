package br.com.clinicaapi.dto;

import br.com.clinicaapi.entities.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDto {

	private Long id;
	private String matricula;
	private String nomeAtendente;
	private String queixas;
	private String plano;
	private String avaliacao;
	private String exames;
	private String encaminhamento;
	private String dataConsulta;
	private String observacao;

	public ConsultaDto(Consulta consulta) {
		this.id = consulta.getId();
		this.matricula = consulta.getMatricula();
		this.nomeAtendente = consulta.getNomeAtendente();
		this.queixas = consulta.getQueixas();
		this.plano = consulta.getPlano();
		this.avaliacao = consulta.getAvaliacao();
		this.exames = consulta.getExames();
		this.encaminhamento = consulta.getEncaminhamento();
		this.dataConsulta = consulta.getDataConsulta();
		this.observacao = consulta.getObservacao();
		}
}
