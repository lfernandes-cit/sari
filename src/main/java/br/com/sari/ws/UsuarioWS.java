package br.com.sari.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.sari.dto.UsuarioDTO;
import br.com.sari.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@EnableWebMvc
@Api(value = "/usario", description = "Operações sobre o Usuário")
@RequestMapping(value = "/usuario")
public class UsuarioWS {

	@Autowired
	UsuarioService userService;

	@ApiOperation(value = "Salvar", notes = "Salva ou atualiza um usuário", response = UsuarioDTO.class)
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public @ResponseBody UsuarioDTO salvar(
			@ApiParam(value = "Usuário do sistema", required = true, name = "usuario") @RequestBody final UsuarioDTO usuarioDTO) {

		userService.salvar(usuarioDTO);

		return usuarioDTO;
	}

	@ApiOperation(value = "Remover", notes = "Remove um usuário", response = String.class)
	@RequestMapping(value = "/remover", method = RequestMethod.DELETE)
	public String remover(@ApiParam(value = "Id do usuario", required = true, name = "id") @RequestParam final Long id) {

		userService.remover(id);

		return "removido";

	}

	@ApiOperation(value = "Listar", notes = "Lista todos os usuários", response = ArrayList.class)
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioDTO> listar() {

		final List<UsuarioDTO> usuarios = userService.listar();

		return usuarios;

	}

	@ApiOperation(value = "Consultar por Id", notes = "Consulta por id", response = UsuarioDTO.class)
	@RequestMapping(value = "/consultarPorId", method = RequestMethod.GET)
	public @ResponseBody UsuarioDTO consultarPorId(@ApiParam(value = "Id do usuario", required = true, name = "id") @RequestParam final Long id) {

		final UsuarioDTO usuario = userService.consultarPorId(id);

		return usuario;

	}

	@ApiOperation(value = "Consultar por Filtro", notes = "Consulta por filtro", response = ArrayList.class)
	@RequestMapping(value = "/consultarPorFiltro", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioDTO> consultarPorFiltro(
			@ApiParam(value = "Nome do usuário", name = "nome") @RequestParam(required = false) final String nome,
			@ApiParam(value = "CPF do usuário", name = "cpf") @RequestParam(required = false) final String cpf) {

		final List<UsuarioDTO> usuarios = userService.consultarPorFiltro(nome, cpf);

		return usuarios;

	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public @ResponseBody UsuarioDTO teste() {

		final UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome("Luiz");

		return usuario;
	}

}
