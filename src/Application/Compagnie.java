package Application;

/* DESCRIPTION **************************************************************************
 *
 * @Author : Josue Lubaki
 *
 * CLASSE COMPAGNIE contenant toutes les proprietés de l'objet Compagnie, les listes de la compagnie ainsi que des getters  et la methode ToString
 ********************************************************************************/
import java.util.ArrayList;

public class Compagnie {

	// Variables d'instances
	protected static  ArrayList<Chauffeur> listeChauffeur;
	protected static  ArrayList<Limousine> listeLimousine;
	protected static  ArrayList<Trajet> listeTrajet;

	/*****************************************************/

	// Constructeurs
	public Compagnie(ArrayList<Chauffeur> listeChauffeur, ArrayList<Limousine> listeLimousine,
					 ArrayList<Trajet> listeTrajet) {

		Compagnie.listeChauffeur = listeChauffeur;
		Compagnie.listeLimousine = listeLimousine;
		Compagnie.listeTrajet = listeTrajet;
	}

	/***************************************************************************************************************************/

	// Methodes d'ajout d'objets a une liste
	public void ajouterChauffeurListe(Chauffeur chauffeur) {
		listeChauffeur.add(chauffeur);
	}

	public void ajouterLimosineListe(Limousine limosine) {
		listeLimousine.add(limosine);
	}

	public void ajouterTrajetListe(Trajet trajet) {
		listeTrajet.add(trajet);
	}

	/*******************************************************/

	// Methode permettant de trouver une limousine a partir de son immatriculation
	public Limousine limosineReservee(String immatriculation) {
		int i;

		for (i = 0; i < listeLimousine.size(); i++) {

			if (listeLimousine.get(i).getImmatriculation().equalsIgnoreCase(immatriculation)) {
				break;
			}
		}

		return listeLimousine.get(i);

	}

	/*******************************************************************************/

	// Methode permettant de trouver un chauffeur a partir de son numero
	// d'enregistrement
	public Chauffeur chauffeurReservee(String numeroIdentification) {
		int i;

		for (i = 0; i < listeChauffeur.size(); i++) {

			if (listeChauffeur.get(i).getNumeroIdentification().equalsIgnoreCase(numeroIdentification)) {
				break;
			}
		}

		return listeChauffeur.get(i);

	}

	/******************************************************************************************/

	// Methodes permettant de verifier si un chauffeur ou une limousine existent
	// dans la liste
	public static boolean validationChauffeurListe(String numeroIdentification) {
		boolean retour = false;

		for (int i = 0; i < listeChauffeur.size(); i++) {

			if (listeChauffeur.get(i).getNumeroIdentification().equalsIgnoreCase(numeroIdentification)) {
				retour = true;
				break;
			}
		}

		return retour;
	}

	public static boolean validationLimosineListe(String immatriculation) {

		boolean retour = false;

		for (int i = 0; i < listeLimousine.size(); i++) {

			if (listeLimousine.get(i).getImmatriculation().equalsIgnoreCase(immatriculation)) {
				retour = true;
				break;
			}
		}

		return retour;
	}

	/******************************************************************************************/
	// methodes qui permet de rechercher un Chauffeur grâce à son son numero d'identification
	public static  Chauffeur rechercheChauffeur(String numeroIdentification) {
		int i = 0;
		if (listeChauffeur.isEmpty()) {
			System.out.println(" \t\t--- Oups ---\n\tLa Liste \"Chauffeurs\" est vide !!! ");
		} else {

			for (i = 0; i < listeChauffeur.size(); i++) {

				if (listeChauffeur.get(i).getNumeroIdentification().equalsIgnoreCase(numeroIdentification)) {
					break;
				}
			}
		}
		return listeChauffeur.get(i);

	}

	// Methode permettant de se rassurer si le kilometrage de depart est bien
	// inferieur a celui a l'arrivee
	public static boolean validationKilometrage(double kilometrageDepart, double kilometrageArrivee) {
		return kilometrageDepart < kilometrageArrivee;
	}

	/*******************************************************************************************************/

	// Methode permettant de valider la creation d'un objet chauffeur
	static public void validationTrajet(String immatriculation, String numeroIdentification, int kilometrageDepart,
										int kilometrageArrivee) throws Exception {

		if (!(validationChauffeurListe(numeroIdentification) && validationLimosineListe(immatriculation)
				&& validationKilometrage(kilometrageDepart, kilometrageArrivee))) {
			throw new Exception();
		}
	}

	/**********************************************************************************************************************************************************/

	// Methode permettant d'afficher un chauffeur a partir de son numero
	// d'enregistrement et son nom
	public void afficher_Chauffeur_Numero_Nom() {
		for (int index = 0; index < listeChauffeur.size(); index++) {
			System.out.println((index + 1) + "- " + listeChauffeur.get(index).getNumeroIdentification_Nom());
		}
	}

	/*****************************************************************************************************/
	// Getters
	public ArrayList<Trajet> getListeTrajet() {
		return listeTrajet;
	}

	public static ArrayList<Chauffeur> getListeChauffeur() {
		return listeChauffeur;
	}

	public ArrayList<Limousine> getListeLimosine() {
		return listeLimousine;
	}

}
