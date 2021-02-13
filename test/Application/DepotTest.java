package Application;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DepotTest extends TestCase {
	Depot depot = new Depot();

	// Constructeur de la Classe DepotTest.java
	public DepotTest(){
		super();
	};

	@Test
	public void testNbreLimousine() {

		Fournisseur four = new Fournisseur("", 0);

		// Incrementation du nombre de Limousines lorsqu'un collaborateur contribue avec
		// des Limousines
		Limousine.nombreLimousine += four.getQuantityLimousineFourni();

		// Reponse Obtenue
		int nombre = Limousine.nombreLimousine;

		// Reponse Attendue
		int reponse = depot.nbreLimousine();

		assertEquals(nombre, reponse);
	}

	@Test
	public void montant_Total() {
		double budgetDepense = 2000;

		// Reponse obtenue
		double reponseObtenue = budgetDepense * Limousine.getNombreLimousine();

		// Reponse Attendue
		double reponseAttendue = depot.montant_Total(budgetDepense);

		assertEquals(reponseObtenue, reponseAttendue);
	}

	/**
	 * L'appel de TestSuite permet à ma classe DepotTest.java d'être visible
	 * lorsqu'il faudra mettre tous les tests ensemble
	 *
	 * @return
	 */
	public static TestSuite suite() {
		return new TestSuite(DepotTest.class);
	}

}
