package br.com.sari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sari.entidades.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
