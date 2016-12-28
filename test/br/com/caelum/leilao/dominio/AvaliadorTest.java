package br.com.caelum.leilao.dominio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
public class AvaliadorTest {

	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Avaliador leiloeiro;

	@Before
	public void criaAvaliador() {
		 joao = new Usuario("Jo�o");
	     jose = new Usuario("Jos�");
	     maria = new Usuario("Maria");
	     
	     leiloeiro = new Avaliador();
	     System.out.println("inicializando teste!");
	     
	}
	
	@After
	public void finaliza() {
		System.out.println("fim");
	}
	
    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // parte 1: cenario
    	Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
    			.lance(joao, 250.0)
    			.lance(jose, 300.0)
    			.lance(maria, 400.0)
    			.constroi();

        // parte 2: acao
        leiloeiro.avalia(leilao);

        // parte 3: validacao
        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
    	Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
    			.lance(joao, 1000.0)
    			.constroi();

        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
    	Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
    }

}