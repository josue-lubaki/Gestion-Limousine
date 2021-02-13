package Application;

/* DESCRIPTION **************************************************************************
 *
 * @Author : Josue Lubaki
 *
 * CLASSE LIMOUSINES contenant toutes les caractéristiques de l'objet Limousines ainsi que des getters et la methode ToString
 ********************************************************************************/
public class Limousine {

	// Variables d'instances
	private final String immatriculation;
	private final String couleur;
	private final int capaciteReservoir;
	public static int nombreLimousine;
	/*****************************/

	// Constructeur
	public Limousine(String numeroImmatriculation, int capaciteReservoir, String couleur) {
		this.immatriculation = numeroImmatriculation;
		this.couleur = couleur;
		this.capaciteReservoir = capaciteReservoir;
		nombreLimousine++;
	}

	/**************************************************************************************/

	// Getter
	public String getImmatriculation() {
		return immatriculation;
	}

	public String getCouleur() {
		return couleur;
	}

	public String getImmatriculation_Couleur() {

		return immatriculation + " " + couleur;
	}

	public static int getNombreLimousine() {
		return nombreLimousine;
	}

	/*******************************************/

	// Methode d'ecriture
	public String toString() {

		return "\n\tImmatriculation: " + immatriculation + "\n\tCapacite du Reservoir: " + capaciteReservoir
				+ "\n\tCouleur: " + couleur;
	}

}