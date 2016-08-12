package br.com.sari.ws;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sari.dto.RespostaPadraoDTO;

@RestController
public class TesteWS {

	private static final String SUCESSO = "Sucesso";
	private static final String OK = "200";

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public @ResponseBody RespostaPadraoDTO teste() {

		final RespostaPadraoDTO resposta = new RespostaPadraoDTO();
		resposta.setMensagem(SUCESSO);
		resposta.setObject("teste");
		resposta.setCodigo(OK);

		return resposta;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(final HttpSession session) {
		session.invalidate();
	}

}