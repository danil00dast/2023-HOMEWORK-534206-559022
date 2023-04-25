package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;




public class ComandoPosaTest {

	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private IO io;
	

	@Before
	public void setUp(){
		partita = new Partita();
		attrezzo = new Attrezzo("bastone", 4);
		comando = new ComandoPosa();
		io = new IOConsole();
		comando.setIo(io);
	}
	 
	/**
   * Test che si occupa di verificare che l'attrezzo nella borsa
   * viene posato correttamente
    **/
	@Test
	public void PosatoTest() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("bastone");
		comando.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("bastone"));
	}
	
	/**
	* Test che si occupa di verificare che un attrezzo non presente in borsa
	* non puo' essere posato 
	**/
	@Test
	public void AttrezzoPosatoNulloTest() {
		comando.setParametro("bastone");
		comando.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("bastone"));
	}
	
	/**
	* Test che si occupa di verificare che il comando corrisponde a 'posa'
	**/
	@Test
	public void GetNomeTest() {
		assertEquals("posa", this.comando.getNome());
	}
}
