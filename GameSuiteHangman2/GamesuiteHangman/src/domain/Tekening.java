package domain;

import java.awt.Graphics;
import java.util.*;

public class Tekening implements Drawable {
	private String naam;
	private static final int MIN_X = 0, MIN_Y = 0, MAX_X = 399, MAX_Y = 399;
	private List<Vorm> vormen;

	@Override
	public void teken(Graphics g) {
		for (Vorm vorm : vormen) {
			if(vorm.isZichtbaar())
				vorm.teken(g);
		}
	}

	public Tekening(String naam) {
		setNaam(naam);
		vormen = new ArrayList<>();
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("naam mag niet leeg zijn.");
		}
		this.naam = naam;
	}

	public int getVorm(int vorm) {
		return vorm;
	}

	public void voegToe(Vorm vorm) {
		if (vorm == null) {
			throw new DomainException("Geen geldige vorm");
		} else if (vorm.getOmhullende().getMaxX() > MAX_X || vorm.getOmhullende().getMaxY() > MAX_Y
				|| vorm.getOmhullende().getMinX() < MIN_X || vorm.getOmhullende().getMinY() < MIN_Y) {
			throw new DomainException("De vorm past niet in de tekening");
		}
		vormen.add(vorm);
	}

	public int getAantalVormen() {
		return vormen.size();

	}

	public void verwijder(Vorm vormTeVerwijderen) {
		for (int i = 0; i < vormen.size(); i++) {
			if (vormen.get(i).equals(vormTeVerwijderen)) {
				vormen.remove(i);
			}
		}
	}

	public boolean bevat(Vorm vorm2) {
		if (vorm2 == null) {
			throw new DomainException("Ongeldige vorm");
		}
		for (Vorm vorm : vormen) {
			if (vorm.equals(vorm2)) {
				return true;
			}
		}
		return false;
	}

	public List<Vorm> getAlleVormen() {
		return vormen;
	}

	@Override
	public String toString() {
		String res = "Tekening met naam " + getNaam() + " bestaat uit " + getAantalVormen() + " vormen: \n";
		for (Vorm vorm : vormen) {
			res += vorm;
		}
		return res;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (object instanceof Tekening) {
			Tekening tekening = (Tekening) object;
			List<Vorm> vormenTekening1 = tekening.getAlleVormen();
			if (vormenTekening1.size() != this.getAantalVormen()) {
				return false;
			} else {
				for (Vorm vorm : vormen) {
					if (!vormenTekening1.contains(vorm)) {
						return false;
					}
				}
			}
		}
		return true;
	}


}
