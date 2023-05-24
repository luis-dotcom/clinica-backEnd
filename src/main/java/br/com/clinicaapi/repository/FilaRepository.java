package br.com.clinicaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.clinicaapi.entities.Fila;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {

	@Query(nativeQuery = true, value = "SELECT count(id) as soma FROM fila WHERE id = id;")
	int findByQuantidadeFila();


}
