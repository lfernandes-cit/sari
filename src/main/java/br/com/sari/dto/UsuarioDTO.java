package br.com.sari.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Usuario", description = "Usuário do sistema")
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String cpf;

	private String nome;

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

}