package br.com.sari;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sari.dto.UsuarioDTO;
import br.com.sari.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-context.xml")
public class UsuarioTest {

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void cadastra() {
		final UsuarioDTO usuarioDTO = new UsuarioDTO("65897458588", "Luiz Gabriel");
		usuarioService.salvar(usuarioDTO);

		Assert.assertNotNull(usuarioDTO.getId());
	}
}
