package br.com.clinicaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.dto.AlunoDto;
import br.com.clinicaapi.entities.Aluno;
import br.com.clinicaapi.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	// buscar por id
	public Aluno findById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
				"Aluno não encontrado! ID:" + id + " Tipo: " + Aluno.class.getName(), null));
	}

	// listar
	public static List<AlunoDto> listarAlunos(List<Aluno> aluno) {
		return aluno.stream().map(AlunoDto::new).collect(Collectors.toList());
	}

	// criar
	public Aluno criarAluno(Aluno aluno) {
		aluno.setId(null);
		return alunoRepository.save(aluno);
	}

	// atualizar
	public Aluno atualizarAluno(Long id, AlunoDto alunoDto) {
		Aluno aluno = findById(id);
		aluno.setMatricula(alunoDto.getMatricula());
		aluno.setNome(alunoDto.getNome());
		aluno.setTipoPerfil(alunoDto.getTipoPerfil());
		aluno.setCpf(alunoDto.getCpf());
		aluno.setEndereco(alunoDto.getEndereco());
		aluno.setEmail(alunoDto.getEmail());
		aluno.setSenha(alunoDto.getSenha());
		aluno.setCurso(alunoDto.getCurso());

		return alunoRepository.save(aluno);
	}

	// deletar
	public void deleteAluno(Long id) {
		findById(id);
		alunoRepository.deleteById(id);
	}
}
