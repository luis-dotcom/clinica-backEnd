package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.PacienteDto;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	// buscar por id
	public Paciente findById(Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		return paciente.orElseThrow(() -> new ObjectNotFoundException(
				"Paciente não encontrado! ID:" + id + " Tipo: " + Paciente.class.getName(), null));
	}
	
	// buscar por id
		public Paciente findByCpf(String cpf) {
			Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
			return paciente.orElseThrow(() -> new ObjectNotFoundException(
					"Paciente não encontrado! CPF:" + cpf + " Tipo: " + Paciente.class.getName(), null));
		}

	// listar
	public static List<PacienteDto> listarPacientes(List<Paciente> paciente) {
		return paciente.stream().map(PacienteDto::new).collect(Collectors.toList());
	}

	// criar
	public Paciente criarPaciente(Paciente paciente) {
		paciente.setId(null);
		return pacienteRepository.save(paciente);
	}

	// atualizar
	public Paciente atualizarPaciente(Long id, PacienteDto pacienteDto) {
		Paciente paciente = findById(id);
		paciente.setNome(pacienteDto.getNome());
		paciente.setDataNascimento(pacienteDto.getDataNascimento());
		paciente.setCpf(pacienteDto.getCpf());
		paciente.setEndereco(pacienteDto.getEndereco());
		paciente.setTelefone(pacienteDto.getTelefone());
		paciente.setEmail(pacienteDto.getEmail());
		paciente.setSexo(pacienteDto.getSexo());
		paciente.setNomeMae(pacienteDto.getNomeMae());
		paciente.setNaturalidade(pacienteDto.getNaturalidade());
		paciente.setBairro(pacienteDto.getBairro());

		return pacienteRepository.save(paciente);
	}

	// deletar
	public void deletePaciente(Long id) {
		findById(id);
		pacienteRepository.deleteById(id);
	}

}
