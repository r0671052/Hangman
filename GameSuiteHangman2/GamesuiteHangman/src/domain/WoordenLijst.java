package domain;

import java.util.ArrayList;
import java.util.List;

public class WoordenLijst {
	private List<String> woorden;

	public WoordenLijst() {
		woorden = new ArrayList<String>();
		// Inlezen van bestand hangman.txt
	}

	public int getAantalWoorden() {
		return woorden.size();
	}

	public void voegToe(String woord){
		if(woord==null||woord.trim().isEmpty())
			throw new DomainException("Woord mag niet leeg zijn.");
		if(!woorden.contains(woord))
			woorden.add(woord);
	}

	public String getRandomWoord() {
		if(woorden.size()==0) throw new DomainException("Geen woorden beschikbaar");
		int index = (int) Math.floor(Math.random() * (woorden.size() - 1));
		return woorden.get(index);
	}
}
