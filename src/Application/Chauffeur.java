package Application;

/* DESCRIPTION **************************************************************************
 *
 * @Author : Josue Lubaki
 *
 * CLASSE CHAUFFEUR contenant toutes les caracteristiques de l'objet Chauffeur, les vaiables d'instances ainsi que Les getters et la methode ToString
 ********************************************************************************/
import java.util.ArrayList;

public class Chauffeur {

	// Variables d'instances
	private final String nom;
	private final String prenom;
	private final String numeroIdentification;
	private final int anneeEmbauche;
	private final String adresse;
	private final ArrayList<Trajet> listeTrajet;

	/******************************************/

	// Constructeur
	public Chauffeur(String nom, String prenom, String numeroIdentification, int anneeEmbauche, String adresse,
					 ArrayList<Trajet> listeTrajet) {

		this.nom = nom;
		this.prenom = prenom;
		this.numeroIdentification = numeroIdentification;
		this.anneeEmbauche = anneeEmbauche;
		this.adresse = adresse;
		this.listeTrajet = listeTrajet;
	}

	/*************************************************************************************************************/

	// Methode permettant de supprimer les caracteres speciaux d'une chaine de
	// caracetere a l'entree
	public static String suppressionCaracteresSpeciaux(String nom) {
		StringBuilder retour = new StringBuilder();

		for (int i = 0; i < nom.length(); i++) {

			if (Character.isLetter(nom.charAt(i))) {
				retour.append(nom.charAt(i));
			}
		}

		return retour.toString();
	}

	/**********************************************************************************************/

	// Methode permettant de construire le numero d'enregistrement d'un chauffeur
	public static String contructionNumeroEnregistrement(String nom, String prenom, int annee) {

		String anneeString = Integer.toString(annee);

		StringBuilder retour = new StringBuilder();

		nom = suppressionCaracteresSpeciaux(nom);
		prenom = suppressionCaracteresSpeciaux(prenom);

		// Je recupere les trois premiers caracteres du nom au quel j'ai pris le soin de
		// retirer les caracteres speciaux
		for (int i = 0; i < 3; i++) {
			retour.append(nom.charAt(i));
		}

		retour.append(prenom.charAt(0));

		// en considerant que l'annen a l'entree sera constituer de 4 caracteres je
		// retiens les caracteres a la
		// 3e et 4e position
		for (int i = 2; i < 4; i++) {
			retour.append(anneeString.charAt(i));
		}

		return retour.toString();
	}

	public boolean validationAnnee(int annee) {
		boolean valide = false;
		String anneeString = Integer.toString(annee);

		// L'annee doit etre de 4 caracteres
		if (anneeString.length() == 4) {
			valide = true;
		}

		return valide;
	}

	/************************************************************************************************/

	public void ajouterTrajetListe(Trajet trajet) {
		listeTrajet.add(trajet);
	}

	// Getters
	public void getLimousine_Chauffeur() {

		if (listeTrajet.isEmpty()) {
			System.out.println("\nCe chauffeur ne conduit aucune Limousine.");
		} else {
			System.out.println("***********************************************************");
			System.out.println("Limousines conduitent par " + nom + ":");
			for (Trajet liste : listeTrajet) {
				System.out.println("-" + liste.getLimousine_Trajet());
			}
			System.out.println("***********************************************************");
		}

	}

	public String getNumeroIdentification() {
		return numeroIdentification;
	}

	public String getNumeroIdentification_Nom() {
		return numeroIdentification + " " + nom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAnneeEmbauche() {
		return anneeEmbauche;
	}

	/******************************************************************************/

	// Methode d'ecriture
	public String toString() {

		return "Nom: " + nom + "\tPrenom: " + prenom + "\tAnnee d'embauche: " + anneeEmbauche + "\tNumero: "
				+ numeroIdentification + "\tAdresse: " + adresse;
	}

}
