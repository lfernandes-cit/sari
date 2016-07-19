package br.com.sari.service;

import java.util.List;

import br.com.sari.dto.UsuarioDTO;

public interface UsuarioService {

	public void salvar(UsuarioDTO usuario);

	public void remover(Long id);

	public List<UsuarioDTO> listar();

}
