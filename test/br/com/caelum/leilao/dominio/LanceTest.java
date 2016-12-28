package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class LanceTest {

	@Test(expected=IllegalArgumentException.class)
	public void deveRecusarLancesComValorZero() {
		new Lance(new Usuario("Jhon Jhones"), 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveRecusarLancesComValorNegativo() {
		new Lance(new Usuario("Jhon Jhones"), -10);
	}

}
