package Application;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ChauffeurTest extends TestCase {
	/**
	 * cr�ation d'une liste vide aidant pour instancier la classe Chauffeur La
	 * classe Chauffeur est instanci�e d'une mani�re globale, donc elle sera vue par
	 * tous les tests de ChauffeurTest.java
	 */
	public ArrayList<Trajet> listeTrajet;

	// Constructeur de la Classe ChauffeurTest.java
	public ChauffeurTest() {
		super();
	};

	Chauffeur personnel = new Chauffeur("Garfield", "John", "GarJ94", 1994, "111 boul Joseph", listeTrajet);

	@Test
	public void testContructionNumeroEnregistrement() {
		// Recuperation du Nom, Prenom et Ann�e d'embauche
		String lastname = personnel.getNom();
		String firstname = personnel.getPrenom();
		int anneeInitiale = personnel.getAnneeEmbauche();

		// Transformation de l'ann�e D'embauche en String
		String anneeString = Integer.toString(anneeInitiale);

		// La variable qui contiendra le resultat finale, elle est null pour le moment
		String retour = "";

		String nom = Chauffeur.suppressionCaracteresSpeciaux(lastname);
		String prenom = Chauffeur.suppressionCaracteresSpeciaux(firstname);

		// Je recupere les trois premiers caracteres du nom au quel j'ai pris le soin de
		// retirer les caracteres speciaux
		for (int i = 0; i < 3; i++) {
			retour = retour + nom.charAt(i);
		}
		retour = retour + prenom.charAt(0);

		// en considerant que l'annen a l'entree sera constituer de 4 caracteres je
		// retiens les caracteres a la
		// 3e et 4e position
		for (int i = 2; i < 4; i++) {
			retour = retour + anneeString.charAt(i);
		}

		// Reponse attendue
		String reponse = Chauffeur.contructionNumeroEnregistrement(lastname, firstname, anneeInitiale);

		assertEquals(retour, reponse);
	}

	/***************************************************************************/
	@Test
	public void testValidationAnnee() {
		// Recuperer l'ann�e d'embauche
		int anneeInitiale = personnel.getAnneeEmbauche();

		// Transformer en Cha�ne de Caract�re
		String anneeInitialeString = Integer.toString(anneeInitiale);

		// Obtenir la Taille de la cha�ne
		int taille_Actuelle = anneeInitialeString.length();

		boolean confirmation = false;

		if (taille_Actuelle == 4) {
			confirmation = true;
		}

		boolean taille_Attendue = personnel.validationAnnee(anneeInitiale);
		assertEquals(confirmation, taille_Attendue);
	}

	/**
	 * L'appel de TestSuite permet � ma classe ChauffeurTest.java d'�tre visible
	 * lorsqu'il faudra mettre tous les tests ensemble
	 *
	 * @return
	 */
	public static TestSuite suite() {
		return new TestSuite(ChauffeurTest.class);
	}

}
