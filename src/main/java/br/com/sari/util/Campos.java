package br.com.sari.util;

public enum Campos {

	//Sistema
	ID                      ("Id"),
	TELEFONE                ("Telefone"),
	TELEFONE_USUARIO        ("Telefone do Usuario"),
	TELEFONE_MASTER         ("Telefone do Master Friend"),
	NICKNAME                ("Nickname"),
	CODIGO_ATIVACAO         ("Código Ativação"),
	EMAIL                   ("Email"),
	DATA_FINAL              ("Data Final"),
	DESC_PRODUTO            ("Descrição Produto"),
	TIPO_CAPITAL            ("Tipo Capital"),
	TIPO_LOTE               ("Tipo Lote"),
	TIPO_COIN               ("Tipo Coin"),
	TIPO_CASH               ("Tipo Cash"),
	LINK_PRODUTO            ("Link Produto"),
	PERIODO_DURACAO         ("Período Duração"),
	PERIDODO_ENTRADA        ("Período Entrada"),
	PRECO                   ("Preço"),
	STATUS                  ("Status"),
	URL_PATROCINADOR        ("Url Patrocinador"),
	VALOR_ENTRADA           ("Valor Entrada"),
	IDLOTE                  ("ID Lote"),
	IDCONQUISTA             ("ID Conquista"),
	ID_DOACAO               ("ID Doação"),
	ID_LOJA                 ("ID LOJA"),
	ID_PRODUTO              ("ID PRODUTO"),
	ID_TIPO_INVESTIMENTO    ("ID Tipo Investimento"),
	ID_USUARIO              ("ID Usuário"),
	ID_INVESTIMENTO         ("ID Investimento"),
	AVATAR                  ("Avatar"),
	VALOR_DOACAO            ("Valor Doacao"),
	NOME                    ("Nome"),
	DESCRICAO               ("Descricao"),
	TIPO_INVESTIMENTO       ("Tipo Investimento"),
	RESGATE_PRECIPITADO     ("ResgatePrecipitado"),
	VALOR                   ("Valor"),
	ACAO			        ("Acao"),
	TIPO_ACAO			    ("Tipo Acao"),
	QUANTIDADE              ("Quantidade"),
	TIPO_DINHEIRO 			("Tipo Dinheiro"),
	LOGIN              ("Login"),
	SENHA              ("Senha");

	private String nome;

	/**
	 * Construtor.
	 * @param nome
	 */
	private Campos(final String nome) {
		setNome(nome);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

}
