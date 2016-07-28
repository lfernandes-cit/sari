package br.com.sari.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the HISTORICO_MEDICO database table.
 *
 */
@Entity
@Table(name="HISTORICO_MEDICO")
@NamedQuery(name="HistoricoMedico.findAll", query="SELECT h FROM HistoricoMedico h")
public class HistoricoMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name = "DESCRICAO")
	private String descricao;

	//bi-directional many-to-one association to Especialidade
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_ESPECIALIDADE")
	private Especialidade especialidade;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_USUARIO")
	private Usuario usuario;

	public HistoricoMedico() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(final Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}