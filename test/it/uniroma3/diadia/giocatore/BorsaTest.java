package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class BorsaTest {

    private Borsa borsa;

    @Before
    public void setUp() {
        borsa = new Borsa(20);
    }


    /**
	 * Test che controlla la corretta aggiunta di due attrezzi alla borsa
	 **/
    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("martello", 5);
        Attrezzo attrezzo2 = new Attrezzo("cacciavite", 3);
        assertTrue(borsa.addAttrezzo(attrezzo1));
        assertTrue(borsa.addAttrezzo(attrezzo2));
    }


    /**
	 * Test che controlla la corretta restituzione di due oggetti presenti nella borsa
	 **/
    @Test
    public void testGetAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("martello", 5);
        Attrezzo attrezzo2 = new Attrezzo("cacciavite", 3);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        assertEquals(attrezzo1, borsa.getAttrezzo("martello"));
        assertEquals(attrezzo2, borsa.getAttrezzo("cacciavite"));
    }

    /**
   	 * Test che controlla la corretta restituzione di 20 (impostato in setUp) come peso max della borsa
   	 **/
    @Test
    public void testPesoMax() {
    	 assertEquals(20, borsa.getPesoMax());
    }

}