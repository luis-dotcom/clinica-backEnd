package br.com.clinicaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long>{

	@Query(nativeQuery = true, value = "SELECT count(id) as soma FROM agenda WHERE id = id;")
	int findByQuantidadeAgendados();


	@Query(nativeQuery = true, value = "Select * from agenda order by id desc;")
   	List<Agenda> findAllDesc();
	
}
