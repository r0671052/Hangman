package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TekeningHangManTest {
	TekeningHangMan tekening;

	@Before
	public void setUp() {
		tekening = new TekeningHangMan("hangman");
	}

	
	@Test
	public void constructor_maakt_tekening_18_vormen_14_onzichtbaar(){
		assertEquals(tekening.getAantalVormen(), 18);
		assertEquals(tekening.getAantalOnzichtbaar(), 14);
	}
	
	@Test
	public void zet_volgende_zichtbaar_zet_volgende_zichtbaar() {
		assertEquals(tekening.getAantalOnzichtbaar(), 14);
		tekening.zetVolgendeZichtbaar();
		assertEquals(tekening.getAantalOnzichtbaar(), 13);
	}

	@Test(expected = DomainException.class)
	public void zet_volgende_gooit_exception_bij_alle_vormen_zichtbaar() {
		for(int i=0;i<15;i++){
			tekening.zetVolgendeZichtbaar();
		}
	}
	
	@Test
	public void reset_zet_alle_vormen_behalve_galg_op_onzichtbaar(){
		tekening.reset();
		assertEquals(tekening.getAantalVormen(), 18);
		assertEquals(tekening.getAantalOnzichtbaar(), 14);
	}
	
	@Test(expected = DomainException.class)
	public void voegToe_gooit_Exception() {
		Cirkel c = new Cirkel(new Punt(50,50),10);
		tekening.voegToe(c);
	}
	@Test(expected = DomainException.class)
	public void verwijder_gooit_Exception() {
		tekening.verwijder(new Cirkel(new Punt(280, 125), 25));
	}
}