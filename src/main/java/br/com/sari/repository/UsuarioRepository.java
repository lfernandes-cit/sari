package br.com.sari.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.sari.entidades.Usuario;

@Repository
@Component
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public List<Usuario> findByNomeContaining(String nome);

	public Usuario findByCpf(String cpf);

	public Usuario findByLoginAndSenha(String login, String senha);

}
