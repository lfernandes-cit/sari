package br.com.sari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sari.entidades.HistoricoMedico;

@Repository
public interface HistoricoMedicoRepository extends CrudRepository<HistoricoMedico, Long> {

	@Query("SELECT h FROM HistoricoMedico h WHERE h.usuario.id = :idUsuario")
	List<HistoricoMedico> findByUsuarioId(@Param("idUsuario") Long idUsuario);

}
