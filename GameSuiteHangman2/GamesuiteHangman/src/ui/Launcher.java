package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.*;

public class Launcher {

	public static void main(String[] args) {
		
		String naam = JOptionPane.showInputDialog("Hallo, wat is jouw naam?");
		Speler speler = null;

		try {
			speler = new Speler(naam);
		} catch (DomainException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		}
		Object[] games = { "Hangman", "Pictionary" };
		Object keuze = JOptionPane.showInputDialog(null, "Welke game? ", "input", JOptionPane.INFORMATION_MESSAGE, null,
				games, null);

		if (keuze.equals("Pictionary")) {
			PictionaryUi.play(speler);
		} else if (keuze.equals("Hangman")) {
			
			WoordenLezer woordenLezer = new WoordenLezer("hangman.txt");
			WoordenLijst woordenlijst = woordenLezer.lees();
			HangMan spel = new HangMan(speler, woordenlijst);
			HangmanPaneel spelpaneel = new HangmanPaneel(spel);
			
			HangManHoofdScherm hangman = new HangManHoofdScherm(spel, spelpaneel);
			hangman.start();
		}
	}
}
