package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.EspecialidadeDto;
import br.com.clinicaapi.entities.Agenda;
import br.com.clinicaapi.entities.Especialidade;
import br.com.clinicaapi.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	// buscar por id
	public Especialidade findById(Long id) {
		Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
		return especialidade.orElseThrow(() -> new ObjectNotFoundException(
				"Especialidade não encontrado! ID:" + id + " Tipo: " + Agenda.class.getName(), null));
	}

	// listar
	public static List<EspecialidadeDto> listarEspecialidades(List<Especialidade> especialidade) {
		return especialidade.stream().map(EspecialidadeDto::new).collect(Collectors.toList());
	}

	// criar
	public Especialidade criarEspecialidade(Especialidade especialidade) {
		especialidade.setId(null);
		return especialidadeRepository.save(especialidade);
	}

	// deletar
	public void deleteEspecialidade(Long id) {
		findById(id);
		especialidadeRepository.deleteById(id);
	}
}
