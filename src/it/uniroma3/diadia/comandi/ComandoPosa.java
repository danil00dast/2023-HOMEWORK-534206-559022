package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";


	
	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
        if(a==null)
        	io.mostraMessaggio("Borsa vuota o comando non valido!!\nAssicurati prima di avere almeno un attrezzo nella borsa\nScrivi il comando 'posa + nome attrezzo'\n(dove 'nome attrezzo' e' il nome dell'attrezzo che vuoi togliere dalla borsa e posare nella stanza)");
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if (!(a==null)) 
			io.mostraMessaggio("Ho posato nella stanza l'attrezzo " +a+ " e l'ho tolto dalla borsa");
	    }
       else {
			io.mostraMessaggio("Non c'e' abbastanza spazio nella stanza!!");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
