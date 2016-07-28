package br.com.sari.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RespostaPadraoDTO implements Serializable {

	private static final long serialVersionUID = 4120850763553260847L;

	private Object object;
	private String mensagem;
	private String codigo;

	public Object getObject() {
		return object;
	}
	public void setObject(final Object response) {
		object = response;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(final String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}



}
