package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LeilaoTest {
	
	private Usuario steveJobs;
	private Usuario billGates;

	@Before
	public void setUp() {
		steveJobs = new Usuario("Steve Jobs");
		billGates = new Usuario("Steve Jobs");
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("before class");
	}
	
	@AfterClass
	public static void testandoAfterClass() {
		System.out.println("after class");
	}
	
	@Test
	public void deveDobrarOUtilmoLanceDado(){
		Leilao leilao = new CriadorDeLeilao().para("Macbook pro 15")
				.lance(steveJobs, 2000.00)
				.lance(billGates, 3000.00)
				.constroi();
		
		leilao.dobraLance(steveJobs);
		assertEquals(4000, leilao.getLances().get(2).getValor(),0.0001);
	}
	
	@Test
	public void naoDeveDobrarCasoNaoHajaLanceAnterior() {
		Leilao leilao = new CriadorDeLeilao().para("Macbook pro 15").constroi();
		leilao.dobraLance(steveJobs);
		
		assertEquals(0, leilao.getLances().size());
	}
	
	@Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15")
                .lance(steveJobs, 2000)
                .lance(billGates, 3000)
                .lance(steveJobs, 4000)
                .lance(billGates, 5000)
                .lance(steveJobs, 6000)
                .lance(billGates, 7000)
                .lance(steveJobs, 8000)
                .lance(billGates, 9000)
                .lance(steveJobs, 10000)
                .lance(billGates, 11000)
                .lance(steveJobs, 12000)
                .constroi();

        assertEquals(10, leilao.getLances().size());
        int ultimo = leilao.getLances().size()-1;
        assertEquals(11000.0, leilao.getLances().get(ultimo).getValor(), 0.00001);
    }    
}
	
	
