package Application;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CompagnieTest extends TestCase {
	// Constructeur de la Classe CompagnieTest.java
	public CompagnieTest(){
		super();
	};

	@Test
	public void testValidationKilometrage() {
		double kilometrageDepart = 2500;
		double kilometrageArrivee = 3500;

		boolean retour = false;

		if (kilometrageDepart < kilometrageArrivee) {
			retour = true;
		}

		// Reponse attendue
		boolean reponseAttendue = Compagnie.validationKilometrage(kilometrageDepart, kilometrageArrivee);

		assertEquals(retour, reponseAttendue);
	}

	/** L'appel de TestSuite permet à ma classe CompagnieTest.java d'être visible 
	 * lorsqu'il faudra mettre tous les tests ensemble
	 * @return
	 */
	public static TestSuite suite() {
		return new TestSuite(CompagnieTest.class);
	}

}
