package br.com.sari.util;

import br.com.sari.exception.BusinessException;



public class BusinessExceptionMessages {

	private static final String SEPARADOR = ": ";

	public static void usuarioNaoEncontrado(final String filtro, final String valorFiltro) throws BusinessException {
		throw new  BusinessException (MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92")
				.concat(filtro + SEPARADOR + valorFiltro)
				.replace("{0}", Entidades.USUARIO.getNome()), "92");
	}

	public static void usuarioNaoEncontrado() throws BusinessException {
		throw new BusinessException(MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").replace("{0}", Entidades.USUARIO.getNome()), "92");
	}

	public static void historicoMedicoNaoEncontrado(final String filtro, final String valorFiltro) throws BusinessException {
		throw new BusinessException(MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").concat(filtro + SEPARADOR + valorFiltro)
				.replace("{0}", Entidades.HISTORICO_MEDICO.getNome()), "92");

	}

	public static void historicoMedicoNaoEncontrado() throws BusinessException {
		throw new BusinessException(
				MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92").replace("{0}", Entidades.HISTORICO_MEDICO.getNome()), "92");
	}

	public static void elementoNaoEncontrado(final Entidades entidade) throws BusinessException {
		throw new  BusinessException (MessagesProperties.getMessage("mensagem.erro.elemento.nao.econtrado.92")
				.replace("{0}", entidade.getNome()), "92");
	}


}
