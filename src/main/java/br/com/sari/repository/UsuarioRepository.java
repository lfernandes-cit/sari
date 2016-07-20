package br.com.sari.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sari.entidades.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public List<Usuario> findByNomeAndCpf(String nome, String cpf);

}
