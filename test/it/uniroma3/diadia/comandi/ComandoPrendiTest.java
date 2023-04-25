package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {

	private ComandoPrendi prendi = new ComandoPrendi();
	private String parametro;
	private String nomeComando;

	@Before
	public void setUp(){
		parametro = "p";
		nomeComando = "prendi";
	}
	
	/**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoPrendi sia 'prendi'
	    **/
	@Test
	public void GetNomeTest() {
		assertEquals(nomeComando, this.prendi.getNome());
	}
	/**
	   * Test che si occupa di verificare che il corretto restituimento di parametro
	    **/
	@Test
	public void GetParametroTest() {
	this.prendi.setParametro(this.parametro);
	assertEquals(parametro, this.prendi.getParametro());
	
	}

}

