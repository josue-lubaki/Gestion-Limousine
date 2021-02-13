package Application;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FournisseurTest extends TestCase {
	// Constructeur de la Classe FournisseurTest.java
	public FournisseurTest(){
		super();
	};

	Fournisseur collaborateurs = new Fournisseur("Saint-Paul", 14);

	@Test
	public void testDepense() {
		// Recuperation de la valeur (14) ci-dessus
		int quantityLimousineFourni = collaborateurs.getQuantityLimousineFourni();

		// montant d'une Limousine (Exemple : 22510 Dollars)
		double montantLimousine = 22510;

		// Reponse Obtenue
		double reponseObtenue = quantityLimousineFourni * montantLimousine;

		// Reponse Attendue
		double reponseAttendue = collaborateurs.depense(montantLimousine);

		assertEquals(reponseObtenue, reponseAttendue);
	}

	@Test
	public void testToString() {
		// Recuperation de tous les paramètres
		String nomFournisseur = collaborateurs.getName();
		int quantityLimousineFourni = collaborateurs.getQuantityLimousineFourni();

		// Reponse Obtenue
		String output_A = "Le Fournisseur " + nomFournisseur + " vient de contribuer avec " + quantityLimousineFourni
				+ " Limousines";

		// Reponse Attendue
		String output_B = collaborateurs.toString();

		assertEquals(output_A, output_B);
	}

	/**
	 * L'appel de TestSuite permet à ma classe FournisseurTest.java d'être visible
	 * lorsqu'il faudra mettre tous les tests ensemble
	 *
	 * @return
	 */

	public static TestSuite suite() {
		return new TestSuite(FournisseurTest.class);
	}

}
