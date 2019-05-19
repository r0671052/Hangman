package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Driehoek extends Vorm implements Drawable {

	private Punt hoekpunt1;
	private Punt hoekpunt2;
	private Punt hoekpunt3;

	public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
		super();
		setHoekpunten(hoekpunt1, hoekpunt2, hoekpunt3);
	}

	@Override
	public void teken(Graphics graphics) {
		if (this.isZichtbaar()) {
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.setStroke(new BasicStroke(5));

			int[] xPoints = { hoekpunt1.getX(), hoekpunt2.getX(), hoekpunt3.getX() };
			int[] yPoints = { hoekpunt1.getY(), hoekpunt2.getY(), hoekpunt3.getY() };
			graphics.drawPolygon(xPoints, yPoints, 3);
		}

	}

	public void setHoekpunten(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
		//Hoekpunten worden aanvaard indien ze niet gelijk zijn of op 1 lijn liggen.
		
		if (hoekpunt1 == null || hoekpunt2 == null || hoekpunt3 == null) {
			throw new DomainException("Ongeldig hoekpunt.");
		}
		if (hoekpunt1.equals(hoekpunt2) || hoekpunt2.equals(hoekpunt3) || hoekpunt3.equals(hoekpunt1)) {
			throw new DomainException("Samenvallende punten zijn niet toegelaten.");
		}

		if (pointsOnLine(hoekpunt1, hoekpunt2, hoekpunt3)) {
			throw new DomainException("Punten liggen op 1 lijn.");
		}

		this.hoekpunt1 = hoekpunt1;
		this.hoekpunt2 = hoekpunt2;
		this.hoekpunt3 = hoekpunt3;

	}

	private boolean pointsOnLine(Punt p1, Punt p2, Punt p3) {
		boolean onLine = false;

		int param1 = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY());
		int param2 = (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());
		if (param1 == param2) {
			onLine = true;
		}

		return onLine;
	}

	public Punt getHoekPunt1() {
		return hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return hoekpunt3;
	}

	@Override
	public boolean equals(Object object) {
		boolean gelijk = false;

		if (object instanceof Driehoek) {
			Driehoek drie = (Driehoek) object;
			if (drie.getHoekPunt1().equals(hoekpunt1) || drie.getHoekPunt1().equals(hoekpunt2)
					|| drie.getHoekPunt1().equals(hoekpunt3)) {
				if (drie.getHoekPunt2().equals(hoekpunt1) || drie.getHoekPunt2().equals(hoekpunt2)
						|| drie.getHoekPunt2().equals(hoekpunt3)) {
					if (drie.getHoekPunt3().equals(hoekpunt1) || drie.getHoekPunt3().equals(hoekpunt2)
							|| drie.getHoekPunt3().equals(hoekpunt3)) {
						gelijk = true;

					}
				}
			}

			// Alternative: sort 2 arrays of Punten, check if arrays are equal
			// -> comparable necessary

		}

		return gelijk;
	}

	@Override
	public String toString() {

		String output = "Driehoek: ";
		output += "hoekpunt1: " + hoekpunt1.toString() + " - hoekpunt2: " + hoekpunt2.toString() + " - hoekpunt3: "
				+ hoekpunt3.toString() + " -\n" + this.getOmhullende().toString();

		return output;
	}

	@Override
	public Omhullende getOmhullende() {
		int x1 = hoekpunt1.getX();
		int x2 = hoekpunt2.getX();
		int x3 = hoekpunt3.getX();
		int y1 = hoekpunt1.getY();
		int y2 = hoekpunt2.getY();
		int y3 = hoekpunt3.getY();
		int minx = Math.min(x1, Math.min(x2, x3));
		int miny = Math.min(y1, Math.min(y2, y3));
		int maxx = Math.max(x1, Math.max(x2, x3));
		int maxy = Math.max(y1, Math.max(y2, y3));
		Punt p = new Punt(minx, miny);
		Omhullende o = new Omhullende(p, maxx - minx, maxy - miny);
		return o;
	}
}
