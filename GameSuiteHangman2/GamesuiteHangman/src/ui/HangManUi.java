package ui;

import javax.swing.JOptionPane;

import domain.DomainException;
import domain.HintWoord;
import domain.Speler;
import domain.TekeningHangMan;
import domain.WoordenLijst;

public class HangManUi {
	private Speler speler;
	private WoordenLijst woordenlijst;

	public HangManUi(Speler speler, WoordenLijst woordenlijst) {
		if (speler == null || woordenlijst == null) {
			throw new UiException("Ongeldige speler of woordenlijst.");
		}

		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}

	public void play() {		
		
		TekeningHangMan tekening = new TekeningHangMan("Hangman");
		GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
		view.setVisible(true);
		view.teken();

		try {
			HintWoord woord = new HintWoord(woordenlijst.getRandomWoord());
			String begin = "";
			String gelukt = "Super, doe zo voor!\n" + begin;
			String mislukt = "Helaas, volgende keer beter!\n";

			while (!woord.isGeraden()) {
				String raad = "";

				do {
					raad = JOptionPane.showInputDialog(null,
							begin + "Rarara, welk woord zoeken we\n" + woord.toString() + "\nGeef een letter:",
							"Hangman - " + speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				} while (raad.trim().isEmpty());

				char letter = raad.toCharArray()[0];
				begin = (woord.raad(letter) ? gelukt : mislukt);
				if(begin.equals(mislukt)){
					tekening.zetVolgendeZichtbaar();
				}

			}
			
			view = new GameHoofdScherm(speler.getNaam(), tekening);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);

		}

	}
}
