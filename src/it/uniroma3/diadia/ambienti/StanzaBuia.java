package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
    private  String attrezzoLucente;
	
	public StanzaBuia(String nome , String attrezzoLucente) {
		super(nome);
		this.attrezzoLucente = attrezzoLucente;
	}

	@Override
	public String getDescrizione() {
		String buio = "Qui c'e'un buio pesto...\nMeglio mettere nella stanza un attrezzo che faccia luce, magari una lanterna!!";
		if(!this.hasAttrezzo(attrezzoLucente))
			return buio;
		else
		return super.getDescrizione();
	}
}
