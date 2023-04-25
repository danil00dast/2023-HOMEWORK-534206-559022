package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComandoNonValidoTest {
    private ComandoNonValido nonValido = new ComandoNonValido();
	private String comando;
	
	@Before
	public void setUp() {
		comando="non valido";
		}
    /**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoNonValido sia 'non valido'
	    **/
	@Test
	public void GetNomeTest() {
	assertEquals(comando, this.nonValido.getNome());
	}
}

