package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {

	private Stanza stanza1;
	private Stanza stanza2;
	private Attrezzo attrezzo;

	@Before
	public void setUp() {
		stanza1 = new Stanza("Stanza 1");
		stanza2 = new Stanza("Stanza 2");
		attrezzo = new Attrezzo("Martello", 3);

	}

	/**
	 * Test che imposta una stanza adiacente ad un'altra e controlla la corretta posizione tra le due stanze
	 **/
	@Test
	public void testImpostaStanzaAdiacente() {
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("nord"));
	}

	/**
	 * Test che controlla la corretta aggiunta di un attrezzo alla stanza
	 **/
	@Test
	public void testAggiungiAttrezzo() {
		assertTrue(stanza1.addAttrezzo(attrezzo));
		}
	/**
	 * Test che controlla la corretta rimozione di un attrezzo alla stanza
	 **/
	@Test
	public void testRimuoviAttrezzo() {
		stanza1.addAttrezzo(attrezzo);
		assertTrue(stanza1.removeAttrezzo(attrezzo));
		}

	}
