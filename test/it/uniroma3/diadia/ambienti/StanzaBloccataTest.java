package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



public class StanzaBloccataTest {

	private StanzaBloccata stanzabloccata;
	private Stanza stanza;
	private Attrezzo a;
	
	@Before
	public void setUp() {
		stanzabloccata = new StanzaBloccata("StanzaBloccata", "nord", "chiave");
		stanza = new Stanza("magazzino");
		a = new Attrezzo("chiave", 1);
		stanzabloccata.impostaStanzaAdiacente("nord", stanza);
		
	}

	/**
	 * Test che si occupa di verificare che la direzione della stanza 
	 * adiacente a quella bloccata sia giusta
	 **/
    @Test
	public void testGetStanzaAdiacenteBloccata() {
		stanzabloccata.addAttrezzo(a);
		assertEquals(stanza, stanzabloccata.getStanzaAdiacente("nord"));
		
	}
   
    /**
	 * Test che si occupa di verificare che la descrizione della stanza 
	 * sbloccata in caso di 'chiave' sia coerente con la sua descrizione
	 **/
	@Test
	public void testGetDescrizioneSbloccata() {
		stanzabloccata.addAttrezzo(a);
		assertEquals(stanzabloccata.toString(), stanzabloccata.getDescrizione());
	}
	


}
