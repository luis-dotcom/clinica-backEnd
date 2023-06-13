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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.ConsultaDto;
import br.com.clinicaapi.entities.Consulta;
import br.com.clinicaapi.repository.ConsultaRepository;
import br.com.clinicaapi.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ConsultaService consultaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Consulta")
	public ResponseEntity<Optional<Consulta>> buscarConsulta(@PathVariable Long id) {
		Optional<Consulta> consulta = consultaRepository.findById(id);
		return ResponseEntity.ok().body(consulta);
	}

	@GetMapping("/todas")
	@Operation(summary = "Listar Todas as Consultas")
	public List<ConsultaDto> listarConsultas() {
		List<Consulta> consultas = consultaRepository.findAll();
		return ConsultaService.listarTodasConsultas(consultas);
	}

	@GetMapping("id")
	// localhost:8086/consultas/id?cliente=1
	@Operation(summary = "Listar Consultas Por Cliente passando ID")
	public ResponseEntity<List<ConsultaDto>> listarConsultasPorClientes(
			@RequestParam(value = "cliente", defaultValue = "0") Long id_cliente) {
		List<Consulta> listaConsultas = consultaService.listarConsultaPorPacientes(id_cliente);
		List<ConsultaDto> listaConsultasDto = listaConsultas.stream().map(ConsultaDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaConsultasDto);
	}
	
	@GetMapping
	// localhost:8086/consultas?cliente=1
	@Operation(summary = "Listar Consultas Por Cliente passando CPF")
	public ResponseEntity<List<ConsultaDto>> listarConsultasPorClientesCPF(
			@RequestParam(value = "cliente", defaultValue = "0") String cpf_cliente) {
		List<Consulta> listaConsultas = consultaService.listarConsultaPorPacientesCPF(cpf_cliente);
		List<ConsultaDto> listaConsultasDto = listaConsultas.stream().map(ConsultaDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaConsultasDto);
	}
	
		@PostMapping
	// localhost:8086/consultas?cliente=1
	@Operation(summary = "Cadastrar Consulta")
	public ResponseEntity<Consulta> cadastrarConsulta(
			@RequestParam(value = "cliente", defaultValue = "0") Long id_cliente,
			@Valid @RequestBody Consulta consulta) {
		Consulta novaConsulta = consultaService.criarConsulta(id_cliente, consulta);
		return ResponseEntity.ok().body(novaConsulta);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Consulta")
	public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody Consulta dados) {
		Consulta novoDados = consultaService.atualizarConsulta(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@PatchMapping("/{id}")
	@Operation(summary = "Atualizar Consulta Patch")
	public ResponseEntity<Consulta> atualizarConsultaPatch(@PathVariable Long id, @Valid @RequestBody Consulta dados) {
		Consulta novoDados = consultaService.atualizarConsulta(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Consulta")
	public ResponseEntity<?> deletarConsulta(@PathVariable Long id) {
		consultaService.deleteConsulta(id);
		return ResponseEntity.ok().build();

	}
}
