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

	private final List<UsuarioDTO> usuariosDTO;

	private List<Usuario> usuarios;

	private final UsuarioDTO usuarioDTO;

	private Usuario usuario;


	public UsuarioServiceImpl() {
		mapper = new DozerBeanMapper();
		usuarioDTO = new UsuarioDTO();
		usuariosDTO = new ArrayList<UsuarioDTO>();
		usuario = new Usuario();

	}

	@Override
	public void salvar(final UsuarioDTO usuarioDTO) {

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

		mapper.map(usuarios, usuariosDTO);
		return usuariosDTO;
	}

	@Override
	public UsuarioDTO consultarPorId(final Long id) {
		usuario = userRepo.findOne(id);
		mapper.map(usuario, usuarioDTO);
		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> consultarPorFiltro(final String nome, final String cpf) {

		usuarios = userRepo.findByNomeLikeAndCpf(usuarioDTO.getNome(), usuario.getCpf());
		mapper.map(usuarios, usuariosDTO);

		return usuariosDTO;
	}

}
