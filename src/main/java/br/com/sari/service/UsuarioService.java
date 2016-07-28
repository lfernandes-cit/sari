package br.com.sari.service;

import java.util.List;

import br.com.sari.dto.UsuarioDTO;
import br.com.sari.exception.BusinessException;

public interface UsuarioService {

	public UsuarioDTO salvar(UsuarioDTO usuario) throws BusinessException;

	public void remover(Long id) throws BusinessException;

	public List<UsuarioDTO> listar() throws BusinessException;

	public UsuarioDTO consultarPorId(Long id) throws BusinessException;

	public List<UsuarioDTO> consultarPorNome(String nome) throws BusinessException;

	public UsuarioDTO consultarPorCpf(String cpf) throws BusinessException;

	public UsuarioDTO login(String login, String senha) throws BusinessException, Exception;

}
