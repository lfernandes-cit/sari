package br.com.sari.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Histórico Médico", description = "Relação do histórico médico do usuário")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HistoricoMedicoDTO implements Serializable {

	private static final long serialVersionUID = -112768916177795216L;

	@ApiModelProperty(name = "idHistoricoMedico")
	private String id;

	private Date data;

	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}