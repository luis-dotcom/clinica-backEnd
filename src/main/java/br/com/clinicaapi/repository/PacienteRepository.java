package br.com.clinicaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query(nativeQuery = true, value = "SELECT count(id) as soma FROM paciente WHERE id = id;")
	int findByQuantidadePacientes();

	@Query(nativeQuery = true, value = "Select * from paciente order by id desc;")
	List<Paciente> findAllDesc();
}
