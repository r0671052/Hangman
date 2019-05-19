package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rechthoek extends Vorm implements Drawable {

	private int breedte, hoogte;
	private Punt linkerbovenhoek;

	public Rechthoek(Punt linkerbovenhoek, int breedte, int hoogte) {
		super();
		this.setLinkerbovenhoek(linkerbovenhoek);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte <= 0)
			throw new DomainException("hoogte mag niet 0 zijn");
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <= 0)
			throw new DomainException("hoogte mag niet 0 zijn");
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() {
		return linkerbovenhoek;
	}

	private void setLinkerbovenhoek(Punt linkerbovenhoek) {
		if (linkerbovenhoek == null)
			throw new DomainException("mag niet null zijn");
		this.linkerbovenhoek = linkerbovenhoek;
	}

	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(this.linkerbovenhoek, this.breedte, this.hoogte);
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: " + getLinkerBovenhoek() + " - breedte: " + getBreedte() + " - hoogte: "
				+ getHoogte();
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Rechthoek) {
			Rechthoek s = (Rechthoek) object;
			if (s.getLinkerBovenhoek().equals(this.getLinkerBovenhoek()) && s.getBreedte() == this.getBreedte()
					&& s.getHoogte() == this.getHoogte())
				return true;
		}
		return false;
	}

	@Override
	public void teken(Graphics graphics) {
		if (this.isZichtbaar()) {
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.setStroke(new BasicStroke(5));
			
			Rechthoek rechthoek = new Rechthoek(getLinkerBovenhoek(), getBreedte(), getHoogte());
			graphics.drawRect(rechthoek.getLinkerBovenhoek().getX(), rechthoek.getLinkerBovenhoek().getY(),
					rechthoek.getBreedte(), rechthoek.getHoogte());
		}
	}
}
