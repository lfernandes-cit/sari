package br.com.sari.exception;

import br.com.sari.util.MessagesProperties;

/**
 * The Class BusinessException.
 */
@SuppressWarnings("serial")
public class BusinessException extends Exception {

	private String codigo;

	/**
	 * @param msg
	 */
	public BusinessException(final String msg) {
		super(msg);
		codigo = null;
	}

	/**
	 * @param msg
	 */
	public BusinessException(final String msg, final String codigo) {
		super(msg);
		this.codigo = codigo;
	}

	/**
	 *
	 * @param code
	 * @param chave
	 * @param params
	 */
	public BusinessException(final String code, final String chave, final Object[] params) {
		super(MessagesProperties.getMessage(chave, params));
		codigo = code;
	}

	/**
	 *
	 * @param code
	 * @param chave
	 * @param cause
	 * @param params
	 */
	public BusinessException(final String code, final String chave, final Throwable cause, final Object[] params) {
		super(MessagesProperties.getMessage(chave, params), cause);
		codigo = code;
	}


	/**
	 * @return the code
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param code the code to set
	 */
	public void setCodigo(final String code) {
		codigo = code;
	}

}
