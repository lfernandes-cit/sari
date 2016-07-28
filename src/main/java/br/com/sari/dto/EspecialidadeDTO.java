package br.com.sari.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Especialidade", description = "Especialidade do médico")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EspecialidadeDTO implements Serializable {

	private static final long serialVersionUID = 4733912119567777113L;

	@ApiModelProperty(name = "idEspecialidade")
	private int id;

	private String nome;

	@ApiModelProperty(hidden = true)
	private List<HistoricoMedicoDTO> historicoMedicos;

	public EspecialidadeDTO() {
	}

	public EspecialidadeDTO(final int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
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
		historicoMedico.setEspecialidade(this);

		return historicoMedico;
	}

	public HistoricoMedicoDTO removeHistoricoMedico(final HistoricoMedicoDTO historicoMedico) {
		getHistoricoMedicos().remove(historicoMedico);
		historicoMedico.setEspecialidade(null);

		return historicoMedico;
	}

}