package br.com.sari.dto;

import java.io.Serializable;
import java.util.Date;

public class HistoricoMedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private Date data;

	private EspecialidadeDTO especialidade;

	private UsuarioDTO usuario;

	public HistoricoMedicoDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public EspecialidadeDTO getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(final EspecialidadeDTO especialidade) {
		this.especialidade = especialidade;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(final UsuarioDTO usuario) {
		this.usuario = usuario;
	}

}