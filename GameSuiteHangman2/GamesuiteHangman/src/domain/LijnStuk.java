package domain;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class LijnStuk extends Vorm implements Drawable {

	private Punt start;
	private Punt einde;

	public LijnStuk(Punt start, Punt einde) {
		super();
		setStartEnEindPunt(start, einde);
	}

	@Override
	public void teken(Graphics graphics) {
		if (this.isZichtbaar()) {

			Graphics2D graphics2D = (Graphics2D) graphics;
			graphics2D.setStroke(new BasicStroke(5));
			LijnStuk lijnstuk = new LijnStuk(new Punt(getStartPunt().getX(), getStartPunt().getY()),
					new Punt(getEindPunt().getX(), getEindPunt().getY()));
			graphics.drawLine(lijnstuk.getStartPunt().getX(), lijnstuk.getStartPunt().getY(),
					lijnstuk.getEindPunt().getX(), lijnstuk.getEindPunt().getY());
		}

	}

	public void setStartEnEindPunt(Punt start, Punt einde) {
		if (start == null) {
			throw new DomainException("Ongeldig startpunt");
		}
		if (einde == null) {
			throw new DomainException("Ongeldig eindpunt");
		}
		if (start.equals(einde)) {
			throw new DomainException("Start- en eindpunt mogen niet gelijk zijn");
		}
		this.start = start;
		this.einde = einde;
	}

	public Punt getStartPunt() {
		return start;
	}

	public Punt getEindPunt() {
		return einde;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof LijnStuk) {
			LijnStuk lijnstuk = (LijnStuk) o;
			if ((this.getStartPunt().equals(lijnstuk.getStartPunt())
					&& this.getEindPunt().equals(lijnstuk.getEindPunt()))
					|| (this.getStartPunt().equals(lijnstuk.getEindPunt())
							&& this.getEindPunt().equals(lijnstuk.getStartPunt()))) {

				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String res = "Lijn: startpunt: " + getStartPunt() + " - eindpunt: " + getEindPunt() + " -\n"
				+ this.getOmhullende().toString();
		return res;
	}

	@Override
	public Omhullende getOmhullende() {

		int x1 = start.getX();
		int x2 = einde.getX();

		int y1 = start.getY();
		int y2 = einde.getY();

		Punt linkerBoven = new Punt(Math.min(x1, x2), Math.min(y1, y2));

		Omhullende omhullend = new Omhullende(linkerBoven, Math.abs(x1 - x2), Math.abs(y1 - y2));

		return omhullend;

	}

}
