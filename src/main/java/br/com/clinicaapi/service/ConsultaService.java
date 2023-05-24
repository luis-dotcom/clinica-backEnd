package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.ConsultaDto;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.entities.Consulta;
import br.com.clinicaapi.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private PacienteService pacienteService;

	// buscar por id
	private Consulta findById(Long id) {
		Optional<Consulta> consulta = consultaRepository.findById(id);
		return consulta.orElseThrow(() -> new ObjectNotFoundException(
				"Consulta não encontrada! ID:" + id + " Tipo: " + Consulta.class.getName(), null));
	}

	public List<Consulta> listarConsultaPorPacientes(Long id_paciente) {
		pacienteService.findById(id_paciente);
		return consultaRepository.findByIdConsulta(id_paciente);
	}

	// listar
	public static List<ConsultaDto> listarTodasConsultas(List<Consulta> consulta) {
		return consulta.stream().map(ConsultaDto::new).collect(Collectors.toList());
	}

	// criar
	public Consulta criarConsulta(Long id_paciente, Consulta consulta) {
		consulta.setId(null);
		Paciente paciente = pacienteService.findById(id_paciente);
		consulta.setPaciente(paciente);
		return consultaRepository.save(consulta);
	}

	// atualizar
	public Consulta atualizarConsulta(Long id, Consulta dados) {
		Consulta novoDados = findById(id);
		atualizarDadosDaConsulta(novoDados, dados);
		return consultaRepository.save(novoDados);
	}

	// atualizar dados da consulta
	private void atualizarDadosDaConsulta(Consulta novoDados, Consulta consulta) {
		novoDados.setQueixas(consulta.getQueixas());
		novoDados.setPlano(consulta.getPlano());
		novoDados.setAvaliacao(consulta.getAvaliacao());
		novoDados.setExames(consulta.getExames());
		novoDados.setEncaminhamento(consulta.getEncaminhamento());
		novoDados.setDataConsulta(consulta.getDataConsulta());
	}

	// deletar
	public void deleteConsulta(Long id) {
		findById(id);
		consultaRepository.deleteById(id);
	}
}
