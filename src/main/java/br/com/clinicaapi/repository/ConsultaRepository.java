package br.com.clinicaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	@Query("SELECT obj FROM Consulta obj WHERE obj.paciente.id = :id_consulta ORDER BY queixas")
	List<Consulta> findByIdConsulta(@Param(value = "id_consulta") Long id_consulta);


	@Query("SELECT obj FROM Consulta obj WHERE obj.paciente.cpf = :id_consulta ORDER BY queixas")
	List<Consulta> findByCpfConsulta(@Param(value = "id_consulta") String cpf_paciente);

}
