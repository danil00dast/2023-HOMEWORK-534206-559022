package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComandoFineTest {
    private ComandoFine fine = new ComandoFine();
	private String comando;
	
	@Before
	public void setUp() {
		comando="fine";
		}
    /**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoFine sia 'fine'
	    **/
	@Test
	public void GetNomeTest() {
	assertEquals(comando, this.fine.getNome());
	}
}

