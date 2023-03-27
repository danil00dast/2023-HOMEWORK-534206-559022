package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO
 *         (da un'idea di Michael Kolling and David J. Barnes)
 *
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"Puoi usare i seguenti comandi:\n"+"'vai'", "'aiuto'", "'prendi + nome oggetto'","'posa + nome oggetto'","'fine'\n"};

	private IOConsole io;
	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
		this.io= new IOConsole();
	}

	public void gioca() {
		String istruzione;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando daEseguire = new Comando(istruzione);
		String nomeComando = daEseguire.getNome();

		if (nomeComando==null) {
			io.mostraMessaggio("Non hai inserito alcun comando!");
			return false;
		}

		else if (nomeComando.equals("vai"))
			this.vai(daEseguire.getParametro());

		else if (nomeComando.equals("aiuto"))
			this.aiuto();

		else if (nomeComando.equals(("prendi")))
			this.prendi(daEseguire.getParametro());

		else if (nomeComando.equals(("posa")))
			this.posa(daEseguire.getParametro());

		else if(nomeComando.equals("fine")) {
			this.fine();
		    return true;
		}

		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for (String element : elencoComandi)
			io.mostraMessaggio(element+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ? nord, sud, est, ovest?");
		direzione = io.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Ti trovi in: " + partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());


	}

	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
	}

	private void posa(String nomeAttrezzo) {
		Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);

	}


	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();

	}
}
