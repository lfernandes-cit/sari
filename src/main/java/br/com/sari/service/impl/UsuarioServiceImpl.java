package br.com.sari.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sari.dto.UsuarioDTO;
import br.com.sari.entidades.Usuario;
import br.com.sari.repository.UsuarioRepository;
import br.com.sari.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository userRepo;

	DozerBeanMapper mapper;

	public UsuarioServiceImpl() {
		mapper = new DozerBeanMapper();
	}

	@Override
	public void salvar(final UsuarioDTO usuarioDTO) {

		final Usuario usuario = new Usuario();
		mapper.map(usuarioDTO, usuario);

		userRepo.save(usuario);

		mapper.map(usuario, usuarioDTO);

	}

	@Override
	public void remover(final Long id) {
		userRepo.delete(id);
	}

	@Override
	public List<UsuarioDTO> listar() {
		final Iterable<Usuario> usuarios = userRepo.findAll();

		final List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		mapper.map(usuarios, usuariosDTO);
		return usuariosDTO;
	}

}
