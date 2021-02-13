package Application;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TrajetTest extends TestCase {

	// Constructeur de la Classe TrajetTest.java
	public TrajetTest(){
		super();
	};

	Limousine limousines;
	Trajet trajet = new Trajet(
			"Trois-Rivères",
			"Montréal",
			1250,
			1421,
			null);

	@Test
	public void testGetKilometrageDepart() {
		// Reponse Obtenue
		double reponse_A = 1250;
		// Reponse Attendue
		double reponse_B = trajet.getKilometrageDepart();

		assertEquals(reponse_A, reponse_B);
	}

	@Test
	public void testToString() {
		// Recuperation de tous les paramètres
		String villeDepart = trajet.getVilleDepart();
		String villeArrivee = trajet.getVilleArrivee();
		double kilometrageDepart = trajet.getKilometrageDepart();
		double kilometrageArrivee = trajet.getKilometrageArrivee();

		// Reponse Obtenue
		String reponse_A = "Depart: " + villeDepart + "\nArrivee: " + villeArrivee + "\nKilometrage de depart: "
				+ kilometrageDepart + "\nKilometrage d'arrivee: " + kilometrageArrivee + "\nLimousine reservee: ["
				+ limousines + "]" + "\n----------------------------------------------------------------------";

		// Reponse Attendue
		String reponse_B = trajet.toString();

		assertEquals(reponse_A, reponse_B);
	}
	/**
	 * L'appel de TestSuite permet à ma classe TrajetTest.java d'être visible
	 * lorsqu'il faudra mettre tous les tests ensemble
	 *
	 * @return
	 */

	public static TestSuite suite() {
		return new TestSuite(TrajetTest.class);
	}

}
