package br.com.sari.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the ESPECIALIDADE database table.
 *
 */
@Entity
@Table(name="ESPECIALIDADE")
@NamedQuery(name="Especialidade.findAll", query="SELECT e FROM Especialidade e")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="NOME")
	private String nome;

	// bi-directional many-to-one association to HistoricoMedico
	@OneToMany(mappedBy = "especialidade")
	private List<HistoricoMedico> historicoMedicos;

	public Especialidade() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public List<HistoricoMedico> getHistoricoMedicos() {
		return historicoMedicos;
	}

	public void setHistoricoMedicos(final List<HistoricoMedico> historicoMedicos) {
		this.historicoMedicos = historicoMedicos;
	}

	public HistoricoMedico addHistoricoMedico(final HistoricoMedico historicoMedico) {
		getHistoricoMedicos().add(historicoMedico);
		historicoMedico.setEspecialidade(this);

		return historicoMedico;
	}

	public HistoricoMedico removeHistoricoMedico(final HistoricoMedico historicoMedico) {
		getHistoricoMedicos().remove(historicoMedico);
		historicoMedico.setEspecialidade(null);

		return historicoMedico;
	}

}