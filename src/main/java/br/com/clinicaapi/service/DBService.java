package br.com.clinicaapi.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.entities.Agenda;
import br.com.clinicaapi.entities.Aluno;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.entities.Consulta;
import br.com.clinicaapi.entities.Especialidade;
import br.com.clinicaapi.entities.Fila;
import br.com.clinicaapi.entities.Usuario;
import br.com.clinicaapi.repository.AgendaRepository;
import br.com.clinicaapi.repository.AlunoRepository;
import br.com.clinicaapi.repository.PacienteRepository;
import br.com.clinicaapi.repository.ConsultaRepository;
import br.com.clinicaapi.repository.EspecialidadeRepository;
import br.com.clinicaapi.repository.FilaRepository;
import br.com.clinicaapi.repository.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private FilaRepository filaRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	public void instaciaBaseDeDados() {

//	for(int i =0; i<10 ; i++) {	

		Fila fila1 = new Fila(null, "Escarlete", "1");
		Fila fila2 = new Fila(null, "Marinez", "2");
		Fila fila3 = new Fila(null, "Mendonça", "3");
		Fila fila4 = new Fila(null, "Jack", "4");
		filaRepository.saveAll(Arrays.asList(fila1, fila2, fila3, fila4));

		Agenda agenda1 = new Agenda(null, "pedro", "12456874526", "2023-02-25", "11 236547895", "Nutrição","jeorge");
		Agenda agenda2 = new Agenda(null, "joao", "80054621378", "2023-02-19", "81 2365878546", "Enfermagem", "carla");
		Agenda agenda3 = new Agenda(null, "inacio", "00125480365", "2023-02-18", "87 456325987", "Fisioterapia", "jonh");
		Agenda agenda4 = new Agenda(null, "joana", "45201587965", "2023-02-28", "83 256987452", "Fisioterapia", "maike");
		agendaRepository.saveAll(Arrays.asList(agenda1, agenda2, agenda3, agenda4));

		Paciente paciente1 = new Paciente(null, "jose", "1989-01-13", "81984661549", "@yahoo.com", "12345678901","masculino", "dona maria", "limoeiro", "rua joaquim nabuco", "caruaru", 30);
		Paciente paciente2 = new Paciente(null, "firmino", "1987-02-14", "84661549", "@gmail.com", "23658974120","masculino", "severina bio", "carpina", "rua cristovao ribeiro de lemos", "são paulo", 31);
		Paciente paciente3 = new Paciente(null, "maria", "1970-05-25", "81991218547", "@hotmail.com", "69854712365","feminino", "dona tereza", "sao paulo", "rua pinto lapa", "carpina", 32);
		pacienteRepository.saveAll(Arrays.asList(paciente1, paciente2, paciente3));
		
		Consulta consulta1 = new Consulta(null, "111", "wesker", "dor de cabeça", "dipirona", "leve", "unidade mista", "nao se aplica","1989-01-13","observacao", paciente1);
		Consulta consulta2 = new Consulta(null,"222", "barry", "dor de barriga", "buscopan", "mediano", "restaracao", "nao se aplica","2023-02-25","observacao", paciente1);
		Consulta consulta3 = new Consulta(null,"333", "rebecca", "dor de no peito", "soro", "grave", "HR", "nao se aplica", "1987-02-14","observação",paciente2);
		Consulta consulta4 = new Consulta(null,"444", "jill", "fratura no pe", "tramal", "gravissimo", "Otavio de freitas","nao se aplica", "2023-02-28","observação", paciente2);
		Consulta consulta5 = new Consulta(null,"555", "leon", "dor nas costas", "torsilax", "leve", "upa", "nao se aplica","1970-05-25","observação", paciente2);
		Consulta consulta6 = new Consulta(null, "666", "clare", "dor", "dipirona", "avaliacao local", "raio x", "hr", "2023-05-18", "paciente idoso", paciente1);
		consultaRepository.saveAll(Arrays.asList(consulta1, consulta2, consulta3, consulta4, consulta5,consulta6));
		
		paciente1.getConsultas().addAll(Arrays.asList(consulta1, consulta2, consulta6));
		paciente2.getConsultas().addAll(Arrays.asList(consulta3, consulta4, consulta5));

		Usuario usuario0 = new Usuario(null, "0001", "admin", "ADMIN", "00000000000", "admin","admin", "admin");
		Usuario usuario1 = new Usuario(null, "1111", "clare", "ADMIN", "12365478952", "rua 01","clare@clare.com", "1111");
		Usuario usuario2 = new Usuario(null, "2222", "leon", "ALUNO", "12365587996", "rua 02","leon@.com", "2222");
		Usuario usuario3 = new Usuario(null, "3333", "ada", "RECEPCIONISTA", "12387965236", "rua 03", "ada@.com","3333");
		usuarioRepository.saveAll(Arrays.asList(usuario0, usuario1, usuario2, usuario3));
		
		Aluno aluno1 = new Aluno(null, "1114", "jone", "ALUNO", "12547896521", "rua 20", "jone@jone.com", "4444", "nutricao");
		Aluno aluno2 = new Aluno(null, "1112", "jax", "ALUNO", "12547896532", "rua 21", "jax@jax.com", "5555", "nutricao");
		Aluno aluno3 = new Aluno(null, "1113", "sub zero", "ALUNO", "12547896543", "rua 22", "subzero@subzero.com", "6666", "nutricao");
		alunoRepository.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
		Especialidade especialidade1 = new Especialidade(null, "Enfermagem", "Enfermagem");
		Especialidade especialidade2 = new Especialidade(null, "Nutrição", "Nutrição");
		Especialidade especialidade3 = new Especialidade(null, "Fisioterapia", "Fisioterapia");
	    especialidadeRepository.saveAll(Arrays.asList(especialidade1,especialidade2,especialidade3));
		// i = i+1;
		// }

	}
}
