package br.com.sari;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sari.config.JUnitConfig;
import br.com.sari.dto.UsuarioDTO;
import br.com.sari.exception.BusinessException;
import br.com.sari.service.HistoricoMedicoService;
import br.com.sari.service.UsuarioService;

public class UsuarioTest extends JUnitConfig {

	private static final String CPF_USUARIO_NAO_CADASTRADO = "999999";
	private static final String CPF_USUARIO_EXISTENTE = "123";
	private static final String NOME_USUARIO_NAO_EXISTENTE = "XXXXX";
	private static final long USUARIO_EXISTENTE = 1l;
	private static final long HISTORICO_CADASTRADO = 1l;
	private static final long USUARIO_NAO_CADASTRADO = 999l;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	HistoricoMedicoService historicoMedicoService;

	@Test
	public void cadastrar() throws BusinessException {
		UsuarioDTO usuarioDTO = new UsuarioDTO("65897458588", "Luiz Gabriel", "login", "senha");
		usuarioDTO = usuarioService.salvar(usuarioDTO);

		Assert.assertNotNull(usuarioDTO.getId());
	}

	@Test
	public void consultarPorId() throws BusinessException {

		final UsuarioDTO usuarioDTO = usuarioService.consultarPorId(USUARIO_EXISTENTE);

		Assert.assertNotNull(usuarioDTO.getId());
	}

	@Test(expected = BusinessException.class)
	public void consultarPorIdFalha() throws BusinessException {

		final UsuarioDTO usuarioDTO = usuarioService.consultarPorId(USUARIO_NAO_CADASTRADO);

		Assert.assertNotNull(usuarioDTO.getId());
	}

	public void consultarPorNome() throws BusinessException {

		final List<UsuarioDTO> usuariosDTO = usuarioService.consultarPorNome("Luiz");

		Assert.assertNotNull(usuariosDTO);
	}

	@Test(expected = BusinessException.class)
	public void consultarPorNomeFalha() throws BusinessException {

		final List<UsuarioDTO> usuariosDTO = usuarioService.consultarPorNome(NOME_USUARIO_NAO_EXISTENTE);

		Assert.assertNotNull(usuariosDTO);
	}

	public void consultarPorCPF() throws BusinessException {

		final UsuarioDTO usuarioDTO = usuarioService.consultarPorCpf(CPF_USUARIO_EXISTENTE);

		Assert.assertNotNull(usuarioDTO);
	}

	@Test(expected = BusinessException.class)
	public void consultarPorCPFFalha() throws BusinessException {

		final UsuarioDTO usuarioDTO = usuarioService.consultarPorCpf(CPF_USUARIO_NAO_CADASTRADO);

		Assert.assertNotNull(usuarioDTO);
	}

	@Test
	public void listar() throws BusinessException {

		final List<UsuarioDTO> usuariosDTO = usuarioService.listar();

		Assert.assertNotNull(usuariosDTO);
	}

	@Test
	public void login() throws Exception {

		final UsuarioDTO usuarioDTO = usuarioService.login("login", "senha");

		Assert.assertNotNull(usuarioDTO);
	}

	@Test(expected = BusinessException.class)
	public void loginFalha() throws Exception {

		final UsuarioDTO usuarioDTO = usuarioService.login("login", "senhaErrada");

		Assert.assertNotNull(usuarioDTO);
	}

	@Test
	public void remover() throws BusinessException {
		historicoMedicoService.remover(HISTORICO_CADASTRADO);
		usuarioService.remover(USUARIO_EXISTENTE);
	}

	@Test
	public void removerFalhaRelacionamento() throws BusinessException {
		usuarioService.remover(USUARIO_EXISTENTE);
	}

	@Test(expected = BusinessException.class)
	public void removerFalha() throws BusinessException {
		usuarioService.remover(USUARIO_NAO_CADASTRADO);
	}
}
