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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinicaapi.dto.FilaDto;
import br.com.clinicaapi.entities.Fila;
import br.com.clinicaapi.repository.FilaRepository;
import br.com.clinicaapi.service.FilaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fila")
public class FilaController {

	@Autowired
	private FilaRepository filaRepository;

	@Autowired
	private FilaService filaService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Fila")
	public ResponseEntity<Optional<Fila>> buscarFila(@PathVariable Long id) {
		Optional<Fila> fila = filaRepository.findById(id);
		return ResponseEntity.ok().body(fila);
	}

	@GetMapping
	@Operation(summary = "Listar Fila")
	public List<FilaDto> listarFila() {
		List<Fila> fila = filaRepository.findAll();
		return FilaService.listarFila(fila);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Fila")
	public ResponseEntity<Fila> cadastrarFila(@Valid @RequestBody Fila fila) {
		fila = filaService.criarFila(fila);
		return ResponseEntity.ok().body(fila);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Fila")
	public ResponseEntity<?> deletarFila(@PathVariable Long id) {
		filaService.deleteFila(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/quantidade")
	@Operation(summary = "Quantidade na Fila")
	public int valorTotalAgendas() {
		int valorTotal = filaRepository.findByQuantidadeFila();
		return valorTotal;
	}
}
