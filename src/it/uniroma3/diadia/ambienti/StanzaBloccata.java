package it.uniroma3.diadia.ambienti;

;
/* La stanza bloccata ha una delle direzioni inaccessibile, 
 * per sbloccare la direzione bisogna posare l'oggetto richiesto*/

public class StanzaBloccata extends Stanza {
    private String direzioneBloccata;
	private String attrezzoSbloccaDirezione;

	public StanzaBloccata(String nome, String direzioneBlc, String attrezzo) {
		super(nome);
		this.direzioneBloccata = direzioneBlc;
		this.attrezzoSbloccaDirezione = attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccaDirezione)) {
			System.out.println("Chiuso!! Non puoi andare ad est senza prima aver posato il pugnale!!");
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		String bloccata = "Stanza bloccata in direzione: " + direzioneBloccata+ "\nPrendi il " + attrezzoSbloccaDirezione + " e posalo in questa stanza per sbloccare direzione " +direzioneBloccata;
		if(!this.hasAttrezzo(attrezzoSbloccaDirezione)) 
			return bloccata;
		else
		return super.getDescrizione();
	}
}
