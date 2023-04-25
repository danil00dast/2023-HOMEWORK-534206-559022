package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando comando;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}
	/**
	   * Test che si occupa di verificare che inserendo un comando non valido 
	   * non corrisponde ai nomi comandi possibili
	    **/
    @Test
	public void ComandoNonValidoTest() {
		comando = new ComandoNonValido();
		assertEquals( comando.getNome(), fabbrica.costruisciComando("comandoNonValido").getNome());
	}
    /**
	   * Test che si occupa di verificare che inserendo un comando valido ad esempio 'aiuto'
	   * corrisponde al getnome di fabbrica 
	    **/
	@Test
	public void ComandoValidoTest() {
		comando = new ComandoAiuto();
		assertEquals( comando.getNome(), fabbrica.costruisciComando("aiuto").getNome());
	}

}
