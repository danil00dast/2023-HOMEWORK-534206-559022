package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;




public class LabirintoTest {

    private Labirinto labirinto;

    @Before
    public void setUp() {
        labirinto = new Labirinto();
        labirinto.creaStanze();
    }

    /**
	 * Test che si occupa di verificare che la stanza vincente è la biblioteca
	 **/
    @Test
    public void testStanzaVincenteBiblioteca() {
        Stanza stanzaVincente = labirinto.getStanzaVincente();
        assertEquals("Biblioteca", stanzaVincente.getNome());
    }


    /**
   	 * Test che si occupa di verificare se viene impostata correttamente la stanza corrente
   	 **/
   @Test
    public void testSetStanzaCorrente() {
        Stanza nuovaStanza = new Stanza("Nuova Stanza");
        labirinto.setStanzaCorrente(nuovaStanza);
        assertEquals(nuovaStanza, labirinto.getStanzaCorrente());
    }


   /**
  	 * Test che si occupa di verificare che la stanza corrente di partenza del programma è atrio
  	 **/
    @Test
    public void testStanzaCorrenteAtrio() {
        Stanza stanzaCorrente = labirinto.getStanzaCorrente();
        assertEquals("Atrio", stanzaCorrente.getNome());
    }
}
