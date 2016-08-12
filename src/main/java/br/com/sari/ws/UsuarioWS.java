package br.com.sari.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sari.dto.RespostaPadraoDTO;
import br.com.sari.dto.UsuarioDTO;
import br.com.sari.exception.BusinessException;
import br.com.sari.service.UsuarioService;
import br.com.sari.util.Messages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "/usuario", description = "Operações sobre o Usuário")
@RequestMapping(value = "/usuario")
public class UsuarioWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@Autowired
	UsuarioService userService;

	@ApiOperation(value = "Salvar", notes = "Salva ou atualiza um usuário")
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public @ResponseBody RespostaPadraoDTO salvar(
			@ApiParam(value = "Usuário do sistema", required = true, name = "usuario") @RequestBody final UsuarioDTO usuarioDTO) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		try {
			userService.salvar(usuarioDTO);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuarioDTO);
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
			userService.remover(id);
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

	@ApiOperation(value = "Listar", notes = "Lista todos os usuários")
	@RequestMapping(value = "/listar**", method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO listar() {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		List<UsuarioDTO> usuarios;
		try {
			usuarios = userService.listar();
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuarios);
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

	@ApiOperation(value = "Consultar por Id", notes = "Consulta por id")
	@RequestMapping(value = "/consultarPorId", method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO consultarPorId(@ApiParam(value = "Id do usuario", required = true, name = "id") @RequestParam final Long id) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		final UsuarioDTO usuario;
		try {
			usuario = userService.consultarPorId(id);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuario);
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

	@ApiOperation(value = "Login", notes = "Login do Usuário no sistema")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody RespostaPadraoDTO login(@ApiParam(value = "login", required = true, name = "login") @RequestParam final String login,
			@ApiParam(value = "senha", required = true, name = "senha") @RequestParam final String senha) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		final UsuarioDTO usuario;
		try {
			usuario = userService.login(login, senha);
			resposta.setObject(usuario);
			resposta.setMensagem(Messages.usuarioLogado());
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

	@ApiOperation(value = "Consultar por Nome", notes = "Consulta por nome")
	@RequestMapping(value = "/consultarPorNome", method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO consultarPorNome(
			@ApiParam(value = "Nome do usuário", required = true, name = "nome") @RequestParam(required = true) final String nome) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		List<UsuarioDTO> usuarios;
		try {
			usuarios = userService.consultarPorNome(nome);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuarios);
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

	@ApiOperation(value = "Consultar por CPF", notes = "Consulta por CPF")
	@RequestMapping(value = "/consultarPorCpf", method = RequestMethod.GET)
	@ApiModelProperty(hidden = true)
	public @ResponseBody RespostaPadraoDTO consultarPorCpf(
			@ApiParam(value = "CPF do usuário", required = true, name = "cpf") @RequestParam(required = true) final String cpf) {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		UsuarioDTO usuario;
		try {
			usuario = userService.consultarPorCpf(cpf);
			resposta.setMensagem(SUCESSO);
			resposta.setObject(usuario);
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
