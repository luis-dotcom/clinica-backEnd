package br.com.clinicaapi.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.PacienteDto;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.repository.PacienteRepository;
import br.com.clinicaapi.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteService pacienteService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Paciente")
	public ResponseEntity<Optional<Paciente>> buscarPacientePorId(@PathVariable Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		return ResponseEntity.ok().body(paciente);
	}

	@GetMapping
	@Operation(summary = "Listar Pacientes")
	public List<PacienteDto> listarPacientes() {
		List<Paciente> paciente = pacienteRepository.findAllDesc();
		return PacienteService.listarPacientes(paciente);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Paciente")
	public ResponseEntity<Paciente> cadastrarPaciente(@Valid @RequestBody Paciente paciente) {
		paciente = pacienteService.criarPaciente(paciente);
		return ResponseEntity.ok().body(paciente);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Paciente")
	public ResponseEntity<PacienteDto> atualizarPaciente(@Valid @PathVariable Long id,
			@RequestBody PacienteDto pacienteDto) {
		Paciente paciente = pacienteService.atualizarPaciente(id, pacienteDto);
		return ResponseEntity.ok(new PacienteDto(paciente));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Paciente")
	public ResponseEntity<?> deletarPaciente(@PathVariable Long id) {
		pacienteService.deletePaciente(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/quantidade")
	@Operation(summary = "Quantidade de Pacientes")
	public int valorTotalPacientes() {
		int valorTotal = pacienteRepository.findByQuantidadePacientes();
		return valorTotal;
	}
}
