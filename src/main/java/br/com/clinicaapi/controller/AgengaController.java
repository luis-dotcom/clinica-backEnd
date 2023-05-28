package br.com.clinicaapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.AgendaDto;
import br.com.clinicaapi.entities.Agenda;
import br.com.clinicaapi.repository.AgendaRepository;
import br.com.clinicaapi.service.AgendaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/agenda")
public class AgengaController {

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private AgendaService agendaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Agenda")
	public ResponseEntity<Optional<Agenda>> buscarAgenda(@PathVariable Long id) {
		Optional<Agenda> agenda = agendaRepository.findById(id);
		return ResponseEntity.ok().body(agenda);
	}

	@GetMapping
	// localhost:8086/agenda?cliente=1
	@Operation(summary = "Listar Agendas Por Cliente passando ID")
	public ResponseEntity<List<AgendaDto>> listarAgendasPorClientes(
			@RequestParam(value = "cliente", defaultValue = "0") Long id_cliente) {
		List<Agenda> listaAgendas = agendaService.listarAgendaPorPacientes(id_cliente);
		List<AgendaDto> listaAgendasDto = listaAgendas.stream().map(AgendaDto::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaAgendasDto);
	}

	@PostMapping
	// localhost:8086/agenda?cliente=1
	@Operation(summary = "Cadastrar Agenda")
	public ResponseEntity<Agenda> cadastrarAgenda(@RequestParam(value = "cliente", defaultValue = "0") Long id_cliente,
			@Valid @RequestBody Agenda agenda) {
		Agenda novaAgenda = agendaService.criarAgenda(id_cliente, agenda);
		return ResponseEntity.ok().body(novaAgenda);
	}

	@GetMapping("/todas")
	@Operation(summary = "Listar Agendas")
	public List<AgendaDto> listarAgendas() {
		List<Agenda> agendas = agendaRepository.findAllDesc();
		return AgendaService.listarAgendas(agendas);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Agenda")
	public ResponseEntity<AgendaDto> atualizarAgenda(@Valid @PathVariable Long id, @RequestBody AgendaDto agendaDto) {
		Agenda agenda = agendaService.atualizarAgenda(id, agendaDto);
		return ResponseEntity.ok(new AgendaDto(agenda));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Agenda")
	public ResponseEntity<?> deletarAgenda(@PathVariable Long id) {
		agendaService.deleteAgenda(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/quantidade")
	@Operation(summary = "Quantidade de Agendados")
	public int valorTotalAgendas() {
		int valorTotal = agendaRepository.findByQuantidadeAgendados();
		return valorTotal;
	}
}
