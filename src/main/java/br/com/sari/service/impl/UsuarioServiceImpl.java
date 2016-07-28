package br.com.sari.service.impl;

import static br.com.sari.util.CheckUtil.isNull;
import static br.com.sari.util.CheckUtil.isNullOrEmpty;

import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.dozer.DozerBeanMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sari.adapter.DozerAdapter;
import br.com.sari.dto.UsuarioDTO;
import br.com.sari.entidades.Usuario;
import br.com.sari.exception.BusinessException;
import br.com.sari.repository.UsuarioRepository;
import br.com.sari.service.UsuarioService;
import br.com.sari.util.AESencrp;
import br.com.sari.util.BusinessExceptionMessages;
import br.com.sari.util.Entidades;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class UsuarioServiceImpl extends DozerAdapter implements UsuarioService {

	@Autowired
	UsuarioRepository userRepo;

	DozerBeanMapper mapper;


	public UsuarioServiceImpl() {
		super();
	}

	@Override
	public UsuarioDTO salvar(final UsuarioDTO usuarioDTO) throws BusinessException {

		try {
			final Usuario usuario = (Usuario) converter(usuarioDTO, Usuario.class);
			usuario.setSenha(AESencrp.encrypt(usuario.getSenha()));
			userRepo.save(usuario);
			return (UsuarioDTO) converter(usuario, UsuarioDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public void remover(final Long id) throws BusinessException {
		try {
			userRepo.delete(id);
		} catch (final EmptyResultDataAccessException e) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Id", id.toString());
		} catch (final ConstraintViolationException e) {
			BusinessExceptionMessages.entidadeComRelacionamentos(Entidades.USUARIO.getNome(), "Id", id.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioDTO> listar() throws BusinessException {
		final List<Usuario> usuarios = IteratorUtils.toList(userRepo.findAll().iterator());

		if (isNullOrEmpty(usuarios)) {
			BusinessExceptionMessages.usuarioNaoEncontrado();
		}

		final List<UsuarioDTO> usuariosDTO = converterLista(usuarios, UsuarioDTO.class);

		return usuariosDTO;
	}

	@Override
	public UsuarioDTO consultarPorId(final Long id) throws BusinessException {
		final Usuario usuario = userRepo.findOne(id);

		if (isNull(usuario)) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Id", id.toString());
		}

		final UsuarioDTO usuarioDTO = (UsuarioDTO) converter(usuario, UsuarioDTO.class);

		return usuarioDTO;
	}

	@Override
	public List<UsuarioDTO> consultarPorNome(final String nome) throws BusinessException {

		final List<Usuario> usuarios = userRepo.findByNomeContaining(nome);

		if (isNullOrEmpty(usuarios)) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Nome", nome);
		}

		final List<UsuarioDTO> usuariosDTO = converterLista(usuarios, UsuarioDTO.class);

		return usuariosDTO;
	}

	@Override
	public UsuarioDTO consultarPorCpf(final String cpf) throws BusinessException {

		final Usuario usuario = userRepo.findByCpf(cpf);

		if (isNull(usuario)) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "CPF", cpf);
		}

		final UsuarioDTO usuarioDTO = (UsuarioDTO) converter(usuario, UsuarioDTO.class);

		return usuarioDTO;
	}

	@Override
	public UsuarioDTO login(final String login, final String senha) throws Exception {

		final Usuario usuario = userRepo.findByLoginAndSenha(login, AESencrp.encrypt(senha));

		if (isNull(usuario)) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.USUARIO.getNome(), "Login", login);
		}

		final UsuarioDTO usuarioDTO = (UsuarioDTO) converter(usuario, UsuarioDTO.class);

		return usuarioDTO;
	}

}
