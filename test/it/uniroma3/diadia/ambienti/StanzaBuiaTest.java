package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;
	private Attrezzo pistola;
	
	@Before
	public void setUp() {
		stanza = new StanzaBuia("StanzaBuia", "lanterna");
		lanterna = new Attrezzo("lanterna", 3);
		pistola = new Attrezzo("pistola", 2);
	}
	
	/**
	 * Test che si occupa di verificare che la descrizione della stanza 
	 * sia visibile in caso di 'lanterna' nella stanza
	 **/
	@Test
	public void testGetDescrizioneNonBuio() {
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	/**
	 * Test che si occupa di verificare che la descrizione della stanza non sia visibile 
	 * e che ci sia buio nel caso di un oggetto diverso da 'lanterna' nella stanza
	 **/
	@Test
	public void testGetDescrizioneBuio() {
		stanza.addAttrezzo(pistola);
		String DescrizioneBuio = "Qui c'e'un buio pesto...\nMeglio mettere nella stanza un attrezzo che faccia luce, magari una lanterna!!";
		assertEquals(DescrizioneBuio, stanza.getDescrizione());
	}

}
