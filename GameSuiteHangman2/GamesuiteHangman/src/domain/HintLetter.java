package domain;

public class HintLetter {

	private boolean geraden;
	private char letter;

	public HintLetter(char letter) {
		setLetter(letter);

	}

	private void setLetter(char letter) {
		this.letter = letter;
		geraden = false;
		if (letter == ' ' || letter == '-') {
			geraden = true;
		}
	}

	public boolean raad(char letter) {
		if (geraden)
			return false;

		if (Character.toLowerCase(this.letter) == Character.toLowerCase(letter)) {
			geraden = true;
		}

		return geraden;
	}

	public boolean isGeraden() {
		return geraden;
	}

	public char toChar() {
		// If geraden == true : return letter else '_'
		return (geraden) ? letter : '_';

	}

	public char getLetter() {
		return letter;
	}

}
