package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	private IO io;
	static final public String[] ELENCO_COMANDI = {"\nPuoi usare i seguenti comandi:\n","vai", "guarda", "prendi + nome attrezzo", "posa + nome attrezzo", "aiuto", "fine"};
	private final static String NOME = "aiuto";

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getParametro() {
	return null;
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
