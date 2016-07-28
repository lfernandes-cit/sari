package br.com.sari.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Usuario", description = "Usuário do sistema")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 2277152019564353965L;

	@ApiModelProperty(name = "idUsuario")
	private String id;

	private String cpf;

	private String nome;

	private String login;

	private String senha;

	@ApiModelProperty(hidden = true)
	private List<HistoricoMedicoDTO> historicoMedicos;


	public UsuarioDTO() {
	}

	public UsuarioDTO(final String cpf, final String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public List<HistoricoMedicoDTO> getHistoricoMedicos() {
		return historicoMedicos;
	}

	public void setHistoricoMedicos(final List<HistoricoMedicoDTO> historicoMedicos) {
		this.historicoMedicos = historicoMedicos;
	}

	public HistoricoMedicoDTO addHistoricoMedico(final HistoricoMedicoDTO historicoMedico) {
		getHistoricoMedicos().add(historicoMedico);
		historicoMedico.setUsuario(this);

		return historicoMedico;
	}

	public HistoricoMedicoDTO removeHistoricoMedico(final HistoricoMedicoDTO historicoMedico) {
		getHistoricoMedicos().remove(historicoMedico);
		historicoMedico.setUsuario(null);

		return historicoMedico;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

}