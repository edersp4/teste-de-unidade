package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		lances.add(lance);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobraLance(Usuario usuario) {
		Lance ultimo = ultimoLanceDo(usuario);
		propoe(new Lance(usuario, ultimo.getValor() * 2));
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		Lance ultimo = null;
		
		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario)) {
				ultimo = lance;
			}
		}
		
		return ultimo;
	}

	
	
}
