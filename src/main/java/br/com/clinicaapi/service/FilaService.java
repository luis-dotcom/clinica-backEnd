package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.FilaDto;
import br.com.clinicaapi.entities.Fila;
import br.com.clinicaapi.repository.FilaRepository;

@Service
public class FilaService {

	@Autowired
	private FilaRepository filaRepository;

	// buscar por id
	public Fila findById(Long id) {
		Optional<Fila> fila = filaRepository.findById(id);
		return fila.orElseThrow(() -> new ObjectNotFoundException(
				"Agendamento não encontrado! ID:" + id + " Tipo: " + Fila.class.getName(), null));
	}

	// listar
	public static List<FilaDto> listarFila(List<Fila> fila) {
		return fila.stream().map(FilaDto::new).collect(Collectors.toList());
	}

	// criar
	public Fila criarFila(Fila fila) {
		fila.setId(null);
		return filaRepository.save(fila);
	}

	// deletar
	public void deleteFila(Long id) {
		findById(id);
		filaRepository.deleteById(id);
	}
}
