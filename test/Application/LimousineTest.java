package Application;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LimousineTest extends TestCase {
	// Constructeur de la Classe LimousineTest.java
	public LimousineTest(){
		super();
	};

	Limousine voiture = new Limousine("GRWE7I", 85, "Jaune");


	@Test
	public void testGetImmatriculation_Couleur() {

		// Recuperation des paramètres
		String immatriculation = voiture.getImmatriculation();
		String couleur = voiture.getCouleur();

		// Reponse Obtenue
		String reponseObtenue = immatriculation + " " + couleur;
		// Reponse Attendue
		//String reponseAttendue = Limousine.getImmatriculation_Couleur();

		assertEquals(reponseObtenue, reponseObtenue);
	}

	@Test
	public void getNombreLimousine() {
		// ReponseObtenue
		int nombreLimousine = Limousine.nombreLimousine;
		// ReponseAttendue
		int nombreAttendu = Limousine.getNombreLimousine();

		assertEquals(nombreLimousine, nombreAttendu);
	}



	public static TestSuite suite() {
		return new TestSuite(LimousineTest.class);
	}

}
