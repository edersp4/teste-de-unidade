package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeilaoTest {
	
	@Test
	public void deveDobrarOUtilmoLanceDado(){
		Leilao leilao = new Leilao("Macbook pro 15");
		Usuario steveJob = new Usuario("Steve Jobs");
		Usuario billGates = new Usuario("Steve Jobs");
		
		leilao.propoe(new Lance(steveJob, 2000.00));
		leilao.propoe(new Lance(billGates, 3000.00));
		leilao.dobraLance(steveJob);
		assertEquals(4000, leilao.getLances().get(2).getValor(),0.0001);
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new Leilao("Macbook pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		
		leilao.dobraLance(steveJobs);
		
		assertEquals(0, leilao.getLances().size());
	}
	
}
