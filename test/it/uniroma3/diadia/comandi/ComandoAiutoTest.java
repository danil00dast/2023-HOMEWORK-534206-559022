package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComandoAiutoTest {
    private ComandoAiuto aiuto = new ComandoAiuto();
	private String comando;
	
	@Before
	public void setUp() {
		comando="aiuto";
		}
    /**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoAiuto sia 'aiuto'
	    **/
	@Test
	public void GetNomeTest() {
	assertEquals(comando, this.aiuto.getNome());
	}
}

