package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}

	@Test(expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null() {
		new LijnStuk(null, punt2);
	}

	@Test(expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null() {
		new LijnStuk(punt1, null);
	}

	@Test(expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_Als_beginpunt_zelfde_als_eindpunt() {
		new LijnStuk(punt1, zelfdeAlsPunt1);

	}

	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn() {
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}

	@Test
	public void equals_moet_false_teruggeven_als_parameter_null() {
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		assertFalse(lijnStuk.equals(null));
	}

	@Test
	public void Equals_Moet_false_teruggeven_Als_LijnStuk1_verschilt_van_LijnStuk2() {
		LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
		LijnStuk lijnstuk2 = new LijnStuk(new Punt(50, 70), new Punt(80, 90));
		assertFalse(lijnstuk1.equals(lijnstuk2));
	}
	/*
	 * @Test public void to_String_heeft_vast_structuur(){ LijnStuk lijnstuk1 =
	 * new LijnStuk(punt1, punt2);
	 * assertEquals("Lijn: startpunt: (10, 20) - eindpunt: (190, 30)",
	 * lijnstuk1); }
	 */

	@Test
	public void getOmhullende_returned_correcte_omhullende() {

		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
		Omhullende o = lijnstuk.getOmhullende();

		Omhullende o2 = new Omhullende(punt1, 180, 10);
		assertEquals(o2, o);
	}

}
