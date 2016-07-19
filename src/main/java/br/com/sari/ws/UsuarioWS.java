package br.com.sari.ws;

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
import io.swagger.annotations.ApiOperation;

@RestController
@EnableWebMvc
@RequestMapping(value = "/usuario")
public class UsuarioWS {

	@Autowired
	UsuarioService userService;

	@ApiOperation(value = "API getIssuerByTicker", notes = "Returns a issuer", response = UsuarioDTO.class)
	@RequestMapping(value = "/salvar", method = RequestMethod.PUT)
	public @ResponseBody UsuarioDTO salvar(@RequestBody final UsuarioDTO usuarioDTO) {

		userService.salvar(usuarioDTO);

		return usuarioDTO;
	}

	@RequestMapping(value = "/remover", method = RequestMethod.DELETE)
	public String remover(@RequestParam final Long id) {

		userService.remover(id);

		return "removido";

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<UsuarioDTO> listar() {

		final List<UsuarioDTO> usuarios = userService.listar();

		return usuarios;

	}

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public @ResponseBody UsuarioDTO teste() {

		final UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNome("Luiz");

		return usuario;
	}

}
