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

import br.com.clinicaapi.dto.EspecialidadeDto;
import br.com.clinicaapi.entities.Especialidade;
import br.com.clinicaapi.repository.EspecialidadeRepository;
import br.com.clinicaapi.service.EspecialidadeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/especialidade")
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private EspecialidadeService especialidadeService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Especialidade")
	public ResponseEntity<Optional<Especialidade>> buscarEspecialidade(@PathVariable Long id) {
		Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
		return ResponseEntity.ok().body(especialidade);
	}

	@GetMapping
	@Operation(summary = "Listar Especialidades")
	public List<EspecialidadeDto> listarEspecialidades() {
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		return EspecialidadeService.listarEspecialidades(especialidades);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Especialidade")
	public ResponseEntity<Especialidade> cadastrarEspecialidade(@Valid @RequestBody Especialidade especialidade) {
		especialidade = especialidadeService.criarEspecialidade(especialidade);
		return ResponseEntity.ok().body(especialidade);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Especialidade")
	public ResponseEntity<?> deletarEspecialidade(@PathVariable Long id) {
		especialidadeService.deleteEspecialidade(id);
		return ResponseEntity.ok().build();
	}
}
