package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class GiocatoreTest {

    private Giocatore giocatore;

    @Before
    public void setUp() {
        giocatore = new Giocatore();
    }


    /**
	 * Test che verifica che i cfu iniziali sono 20
	 **/
    @Test
    public void testGetCfu() {
        int cfu = giocatore.getCfu();
        assertEquals(20, cfu);
    }

    /**
	 * Test che imposta e verifica che i cfu possano essere 10 in questo caso
	 **/
    @Test
    public void testSetCfu() {
        giocatore.setCfu(10);
        int cfu = giocatore.getCfu();
        assertEquals(10, cfu);
    }

    /**
	 * Test che verifica la restituzione di una borsa con peso 0
	 **/
    @Test
    public void testGetBorsa() {
        Borsa borsa = giocatore.getBorsa();
        assertEquals(0, borsa.getPeso());
    }
}