package br.com.sari;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sari.config.JUnitConfig;
import br.com.sari.dto.EspecialidadeDTO;
import br.com.sari.dto.HistoricoMedicoDTO;
import br.com.sari.dto.UsuarioDTO;
import br.com.sari.exception.BusinessException;
import br.com.sari.service.HistoricoMedicoService;


public class HistoricoMedicoTest extends JUnitConfig {

	private static final long USUARIO_EXISTENTE = 1l;
	private static final int ESPECIALIDADE_EXISTENTE = 1;
	private static final long USUARIO_NAO_CADASTRADO = 999l;
	private static final long HISTORICO_NAO_CADASTRADO = 999l;
	private static final long HISTORICO_CADASTRADO = 1l;

	@Autowired
	HistoricoMedicoService historicoMedicoService;

	@Test
	public void cadastrar() throws BusinessException {
		final UsuarioDTO usuarioDTO = new UsuarioDTO(USUARIO_EXISTENTE);
		final EspecialidadeDTO especialidadeDTO = new EspecialidadeDTO(ESPECIALIDADE_EXISTENTE);
		HistoricoMedicoDTO historicoMedico = new HistoricoMedicoDTO("Acidente em algum lugar", usuarioDTO, especialidadeDTO);
		historicoMedico = historicoMedicoService.salvar(historicoMedico);

		Assert.assertNotNull(historicoMedico.getId());
	}

	@Test
	public void listarPorUsuario() throws BusinessException {

		final List<HistoricoMedicoDTO> historicosMedico = historicoMedicoService.listarPorUsuario(USUARIO_EXISTENTE);

		Assert.assertNotNull(historicosMedico);
	}

	@Test(expected = BusinessException.class)
	public void listarPorUsuarioFalha() throws BusinessException {
		historicoMedicoService.listarPorUsuario(USUARIO_NAO_CADASTRADO);
	}

	@Test
	public void remover() throws BusinessException {
		historicoMedicoService.remover(HISTORICO_CADASTRADO);
	}

	@Test(expected = BusinessException.class)
	public void removerFalha() throws BusinessException {
		historicoMedicoService.remover(HISTORICO_NAO_CADASTRADO);
	}
}
