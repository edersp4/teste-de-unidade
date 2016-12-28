package br.com.caelum.leilao.exercicio;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void test() {
		AnoBissexto anoBissexto = new AnoBissexto();
		assertTrue(anoBissexto.ehBissexto(2016));
		assertTrue(anoBissexto.ehBissexto(2012));
	}
	
	@Test
	public void naoDeveRetornarAnoBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		assertFalse(anoBissexto.ehBissexto(2015));
		assertFalse(anoBissexto.ehBissexto(2011));
	}

}
