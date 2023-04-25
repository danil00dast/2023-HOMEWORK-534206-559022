package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
   	private ComandoVai vai= new ComandoVai();
    private String direzione;
    private String comando;
    
    @Before 
    public void setUp() {
     direzione="est";
     comando="vai";
    	
        
    }
    /**
	   * Test che si occupa di verificare che il getnome di un tipo ComandoVai sia 'vai'
	    **/
	@Test
	public void GetNomeTest() {
		assertEquals(comando, this.vai.getNome());
	}
	  
	/**
	   * Test che si occupa di verificare che il corretto restituimento di parametro
	    **/
	@Test
	public void GetParametroTest() {
		this.vai.setParametro(direzione);
		assertEquals(direzione, this.vai.getParametro());
	}
}
