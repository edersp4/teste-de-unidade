package br.com.caelum.leilao.dominio;

public class CriadorDeLeilao {
	private Leilao leilao;
	
	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario joao, double valor) {
		this.leilao.propoe(new Lance(joao, valor));
		return this;
	}

	public Leilao constroi() {
		return this.leilao;
	}
	
	

}
