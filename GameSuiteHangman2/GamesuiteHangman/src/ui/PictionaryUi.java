
package ui;

import javax.swing.JOptionPane;
import domain.*;

public class PictionaryUi {
	
	public static void play(Speler speler1) {
		Speler speler = speler1;
		Tekening tekening = new Tekening("Tekening");

		boolean stop = false;
		while (!stop) {
			int keuze2 = Integer.parseInt(JOptionPane.showInputDialog(
					"Wat wil je doen: \n\n" + "1. Vorm maken \n" + "2. Tekening tonen \n\n" + "0. Stoppen"));
			if (keuze2 == 1) {
				Object[] shapes = { "Cirkel", "Rechthoek", "Lijnstuk", "Driehoek" };
				Object keuze = JOptionPane.showInputDialog(null, "Welke vorm? ", "input",
						JOptionPane.INFORMATION_MESSAGE, null, shapes, null);

				if (keuze.equals("Cirkel")) {
					try {
						int x = Integer.parseInt(JOptionPane.showInputDialog("x-coordinaat van het middelpunt:"));
						int y = Integer.parseInt(JOptionPane.showInputDialog("y-coordinaat van het middelpunt:"));
						int radius = Integer.parseInt(JOptionPane.showInputDialog("Radius van de cirkel:"));
						Punt punt = new Punt(x, y);
						Cirkel cirkel = new Cirkel(punt, radius);
						tekening.voegToe(cirkel);
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "geen geldig getal", null, JOptionPane.ERROR_MESSAGE);
					}
				} else if (keuze.equals("Rechthoek")) {
					try {
						int x = Integer.parseInt(JOptionPane.showInputDialog("x-coordinaat van linkerbovenhoek:"));
						int y = Integer.parseInt(JOptionPane.showInputDialog("y-coordinaat van linkerbovenhoek:"));

						Punt punt = new Punt(x, y);
						int breedte = Integer.parseInt(JOptionPane.showInputDialog("breedte:"));
						int hoogte = Integer.parseInt(JOptionPane.showInputDialog("hoogte:"));
						Rechthoek rechthoek = new Rechthoek(punt, breedte, hoogte);
						tekening.voegToe(rechthoek);
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "geen geldig getal", null, JOptionPane.ERROR_MESSAGE);
					}
				} else if (keuze.equals("Lijnstuk")) {
					try {

						int x = Integer.parseInt(JOptionPane.showInputDialog("punt1:x-coordinaat?"));
						int y = Integer.parseInt(JOptionPane.showInputDialog("punt1:y-coordinaat?"));
						Punt punt1 = new Punt(x, y);
						int x2 = Integer.parseInt(JOptionPane.showInputDialog("punt2:x-coordinaat?"));
						int y2 = Integer.parseInt(JOptionPane.showInputDialog("punt2:y-coordinaat?"));
						Punt punt2 = new Punt(x2, y2);
						LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
						tekening.voegToe(lijnstuk1);
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "geen geldig getal", null, JOptionPane.ERROR_MESSAGE);
					}
				} else if (keuze.equals("Driehoek")) {
					try {
						int x1 = Integer.parseInt(JOptionPane.showInputDialog("x-coordinaat van hoekpunt1:"));
						int y1 = Integer.parseInt(JOptionPane.showInputDialog("y-coordinaat van hoekpunt1:"));

						int x2 = Integer.parseInt(JOptionPane.showInputDialog("x-coordinaat van hoekpunt2:"));
						int y2 = Integer.parseInt(JOptionPane.showInputDialog("y-coordinaat van hoekpunt2:"));

						int x3 = Integer.parseInt(JOptionPane.showInputDialog("x-coordinaat van hoekpunt3:"));
						int y3 = Integer.parseInt(JOptionPane.showInputDialog("y-coordinaat van hoekpunt3:"));

						Punt punt1 = new Punt(x1, y1);
						Punt punt2 = new Punt(x2, y2);
						Punt punt3 = new Punt(x3, y3);
						Driehoek driehoek = new Driehoek(punt1, punt2, punt3);
						tekening.voegToe(driehoek);
					} catch (DomainException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "geen geldig getal", null, JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (keuze2 == 2) {
				GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), tekening);
				view.setVisible(true);
				view.teken();
			} else if (keuze2 == 0) {
				stop = true;
			} else {
				JOptionPane.showMessageDialog(null, "Voer een geldig nummer in. ");
			}
		}

	}
}