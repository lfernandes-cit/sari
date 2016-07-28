package br.com.sari.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the USUARIO database table.
 *
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="CPF")
	private String cpf;

	@Column(name="NOME")
	private String nome;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "SENHA")
	private String senha;

	//bi-directional many-to-one association to HistoricoMedico
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<HistoricoMedico> historicoMedicos;

	public Usuario() {
	}


	public Usuario(final String cpf, final String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
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

	public List<HistoricoMedico> getHistoricoMedicos() {
		return historicoMedicos;
	}

	public void setHistoricoMedicos(final List<HistoricoMedico> historicoMedicos) {
		this.historicoMedicos = historicoMedicos;
	}

	public HistoricoMedico addHistoricoMedico(final HistoricoMedico historicoMedico) {
		getHistoricoMedicos().add(historicoMedico);
		historicoMedico.setUsuario(this);

		return historicoMedico;
	}

	public HistoricoMedico removeHistoricoMedico(final HistoricoMedico historicoMedico) {
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