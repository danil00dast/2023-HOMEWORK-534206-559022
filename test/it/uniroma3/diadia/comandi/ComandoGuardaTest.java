package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComandoGuardaTest {
	private ComandoGuarda guarda= new ComandoGuarda();
	private String comando;
   
	@Before
	public void setUp() {
		comando = "guarda";
	}
	/**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoGuarda sia 'guarda'
	    **/
	@Test
	public void GetNomeTest() {
		assertEquals(comando, this.guarda.getNome());
		}

}
