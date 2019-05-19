package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Cirkel extends Vorm implements Drawable {

	private int radius;
	private Punt middelpunt;

	public Cirkel(Punt middelPunt, int radius) {
		super();
		setMiddelpunt(middelPunt);
		setRadius(radius);

	}

	public Punt getMiddelpunt() {
		return this.middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) {
		if (middelpunt == null) {
			throw new DomainException("Middelpunt mag niet null zijn.");
		}

		this.middelpunt = middelpunt;
	}

	public int getRadius() {
		return this.radius;

	}

	private void setRadius(int radius) {
		if (radius <= 0) {
			throw new DomainException("De straal moet strikt positief zijn.");
		}
		this.radius = radius;
	}

	@Override
	public String toString() {
		String output = "Cirkel: ";
		output += "middelPunt: " + middelpunt.toString();
		output += " - straal: " + radius;
		return output;

	}

	@Override
	public boolean equals(Object o) {

		boolean gelijk = false;
		if (o instanceof Cirkel) {
			Cirkel c = (Cirkel) o;
			if (this.getRadius() == c.getRadius() && this.getMiddelpunt() == c.getMiddelpunt()) {
				gelijk = true;
			}

		}
		return gelijk;
	}

	@Override

	public Omhullende getOmhullende() {

		Punt linkerBoven = new Punt(middelpunt.getX() - radius, middelpunt.getY() - radius);
		Omhullende o = new Omhullende(linkerBoven, 2 * radius, 2 * radius);

		return o;
	}
	
	@Override
	public void teken(Graphics graphics) {
		if (this.isZichtbaar()) {
			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.setStroke(new BasicStroke(5));

			graphics.drawOval(this.getOmhullende().getMinX(), this.getOmhullende().getMinY(),
					this.getOmhullende().getBreedte(), this.getOmhullende().getHoogte());
		}
	}

}
