package br.com.sari.util;

public enum Entidades {

	// Sistema
	USUARIO                 ("Usuário"),
	HISTORICO_MEDICO		("Histórico Médico");

	private String nome;

	private Entidades(final String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
