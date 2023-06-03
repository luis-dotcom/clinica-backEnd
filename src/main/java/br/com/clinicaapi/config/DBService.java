package br.com.clinicaapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinicaapi.entities.Aluno;
import br.com.clinicaapi.entities.Consulta;
import br.com.clinicaapi.entities.Especialidade;
import br.com.clinicaapi.entities.Fila;
import br.com.clinicaapi.entities.Paciente;
import br.com.clinicaapi.entities.Usuario;
import br.com.clinicaapi.repository.AlunoRepository;
import br.com.clinicaapi.repository.ConsultaRepository;
import br.com.clinicaapi.repository.EspecialidadeRepository;
import br.com.clinicaapi.repository.FilaRepository;
import br.com.clinicaapi.repository.PacienteRepository;
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
		

		Paciente paciente1 = new Paciente(null, "jose", "1989-01-13", "81984661549", "@yahoo.com", "12345678901","masculino", "dona maria", "limoeiro", "rua joaquim nabuco", "caruaru","centro");
		Paciente paciente2 = new Paciente(null, "firmino", "1987-02-14", "84661549", "@gmail.com", "23658974120","masculino", "severina bio", "carpina", "rua cristovao ribeiro de lemos", "são paulo", "sao paulo");
		Paciente paciente3 = new Paciente(null, "maria", "1970-05-25", "81991218547", "@hotmail.com", "69854712365","feminino", "dona tereza", "sao paulo", "rua pinto lapa", "carpina", "novo");
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

		Usuario usuario = new Usuario(null, "0001", "admin", "ADMIN", "00000000000", "admin","12547885","admin","admin");
		Usuario professor1 = new Usuario(null, "1111", "clare", "PROFESSOR", "12365478952", "rua 01","8185696524","professor", "professor");
		Usuario professor2 = new Usuario(null, "2222", "leon", "PROFESSOR", "12365587996", "rua 02","8184569885","leon@.com", "2222");
		Usuario recepcionista = new Usuario(null, "3333", "ada", "RECEPCIONISTA", "12387965236", "rua 03","8173658985", "recepcao","recepcao");
		usuarioRepository.saveAll(Arrays.asList(usuario,professor1,professor2,recepcionista));
		
		Aluno aluno1 = new Aluno(null, "1114", "jone", "ALUNO", "12547896521", "rua 20", "8178456955","aluno","aluno","enfermagem");
		Aluno aluno2 = new Aluno(null, "1112", "jax", "ALUNO", "12547896532", "rua 21", "8197365874", "jax@jax.com", "5555","nutricao");
		Aluno aluno3 = new Aluno(null, "1113", "sub zero", "ALUNO", "12547896543", "rua 22", "81956231478", "sub@sub.com", "77777","fisioterapia");
		alunoRepository.saveAll(Arrays.asList(aluno1,aluno2,aluno3));
		
		Especialidade especialidade1 = new Especialidade(null, "Enfermagem", "Enfermagem");
		Especialidade especialidade2 = new Especialidade(null, "Nutrição", "Nutrição");
		Especialidade especialidade3 = new Especialidade(null, "Fisioterapia", "Fisioterapia");
	    especialidadeRepository.saveAll(Arrays.asList(especialidade1,especialidade2,especialidade3));
		// i = i+1;
		// }

	}
}
