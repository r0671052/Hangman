package domain;

public class Omhullende {
	private int breedte, hoogte;
	private Punt positieLinksBoven;

	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
		// test
		this.setpositieLinksBoven(positieLinksBoven);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte < 0)
			throw new DomainException("hoogte mag niet 0 zijn");
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte < 0)
			throw new DomainException("hoogte mag niet 0 zijn");
		this.hoogte = hoogte;
	}

	public Punt getLinkerBovenhoek() {
		return positieLinksBoven;
	}

	private void setpositieLinksBoven(Punt positieLinksBoven) {
		if (positieLinksBoven == null)
			throw new DomainException("mag niet null zijn");
		this.positieLinksBoven = positieLinksBoven;
	}

	public int getMaxX() {
		return positieLinksBoven.getX() + breedte;
	}

	public int getMaxY() {
		return positieLinksBoven.getY() + hoogte;

	}

	public int getMinX() {
		return positieLinksBoven.getX();
	}

	public int getMinY() {
		return positieLinksBoven.getY();

	}

	@Override
	public String toString() {
		return "Omhullende: (" + positieLinksBoven.getX() + ", " + positieLinksBoven.getY() + ")" + breedte + "-"
				+ hoogte;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Omhullende) {
			Omhullende s = (Omhullende) object;
			if (s.getLinkerBovenhoek().equals(this.getLinkerBovenhoek()) && s.getBreedte() == this.getBreedte()
					&& s.getHoogte() == this.getHoogte())
				return true;
		}
		return false;
	}

}
