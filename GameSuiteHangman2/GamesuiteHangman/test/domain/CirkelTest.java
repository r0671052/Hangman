package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CirkelTest {
	
	
	private Punt middelpunt1 = new Punt(10, 10);
	private Punt middelpunt2 = new Punt(50, 20);

	@Test
	public void Cirkel_wordt_aangemaakt_met_geldig_middelpunt_en_geldige_straal(){
		Cirkel cirkel = new Cirkel(middelpunt1, 20);
		assertEquals(middelpunt1,cirkel.getMiddelpunt());
		assertEquals(20, cirkel.getRadius());		
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_moet_Exception_gooien_als_middelpunt_is_null(){
		new Cirkel(null,5);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_moet_Exception_gooien_als_straal_kleiner_dan_0(){
		new Cirkel(middelpunt1,-5);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_moet_Exception_gooien_als_straal_is_gelijk_aan_0(){
		new Cirkel(middelpunt1,0);
	}
	
	@Test
	public void Twee_cirkels_gelijk_bij_gelijke_middelpunten_en_straal(){
		Cirkel cirkel = new Cirkel(middelpunt1,5);
		Cirkel cirkel2 = new Cirkel(middelpunt1,5);
		assertEquals(true, cirkel.equals(cirkel2));
	}
	
	@Test
	public void Twee_cirkels_gelijk_met_cirkel2_is_null(){
		Cirkel cirkel = new Cirkel(middelpunt1,5);
		Cirkel cirkel2 = null;
		assertEquals(false, cirkel.equals(cirkel2));
	}
	
	@Test
	public void Twee_cirkels_gelijk_met_verschillend_middelpunt(){
		Cirkel cirkel = new Cirkel(middelpunt1,5);
		Cirkel cirkel2 = new Cirkel(middelpunt2,5);
		assertEquals(false, cirkel.equals(cirkel2));
	}
	@Test
	public void Twee_cirkels_gelijk_met_verschillende_straal(){
		Cirkel cirkel = new Cirkel(middelpunt1,5);
		Cirkel cirkel2 = new Cirkel(middelpunt1,10);
		assertEquals(false, cirkel.equals(cirkel2));
	}
	
	@Test
	public void Omhullende_returned_correcte_omhullende(){
		Cirkel cirkel = new Cirkel(middelpunt1,5);
		Omhullende o1 = cirkel.getOmhullende();
		Omhullende o2 = new Omhullende(new Punt(5,5), 10, 10);
		assertEquals(o1, o2);
	}
}
