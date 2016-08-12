package br.com.sari.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sari.dto.HistoricoMedicoDTO;
import br.com.sari.dto.RespostaPadraoDTO;
import br.com.sari.exception.BusinessException;
import br.com.sari.service.HistoricoMedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/historicoMedico", description = "Operações sobre o Histórico Médico do usuário")
@RequestMapping(value = "/historicoMedico")
public class HistoricoMedicoWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@Autowired
	HistoricoMedicoService historicoMedicoService;

	@ApiOperation(value = "Salvar", notes = "Salva ou atualiza um histórico médico")
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public @ResponseBody RespostaPadraoDTO salvar(
			@ApiParam(value = "Histórico Médico do usuário", required = true,
			name = "historicoMedico") @RequestBody final HistoricoMedicoDTO historicoMedicoDTO) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			historicoMedicoService.salvar(historicoMedicoDTO);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(historicoMedicoDTO);
			resposta.setCodigo(OK);
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

		return resposta;

	}

	@ApiOperation(value = "Remover", notes = "Remove um usuário")
	@RequestMapping(value = "/remover", method = RequestMethod.DELETE)
	public RespostaPadraoDTO remover(@ApiParam(value = "Id do usuario", required = true, name = "id") @RequestParam final Long id) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			historicoMedicoService.remover(id);
			resposta.setMensagem(SUCESSO);
			resposta.setCodigo(OK);
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

		return resposta;

	}

	@ApiOperation(value = "Listar Por Usuário", notes = "Lista histórico médico por usuário")
	@RequestMapping(value = "/listarPorUsuario", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody RespostaPadraoDTO listarPorUsuario(
			@ApiParam(value = "Id do usuario", required = true, name = "idUsuario") @RequestParam final Long idUsuario) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		List<HistoricoMedicoDTO> historicosMedico;
		try {
			historicosMedico = historicoMedicoService.listarPorUsuario(idUsuario);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(historicosMedico);
			resposta.setCodigo(OK);
			return resposta;
		} catch (final BusinessException e) {
			resposta.setMensagem(e.getMessage());
			resposta.setCodigo(e.getCodigo());
			return resposta;
		} catch (final Exception e) {
			resposta.setMensagem(e.getMessage());
			return resposta;
		}

	}

}
