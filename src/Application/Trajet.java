package Application;

/* DESCRIPTION **************************************************************************
 *
 * @Author : Josue Lubaki
 *
 * CLASSE TRAJET contenant toutes les proprietés de l'objet Trajet ainsi que des getters et la methode ToString
 ********************************************************************************/
public class Trajet {

	// Variables d'instances
	private final String villeDepart;
	private final String villeArrivee;
	private final double kilometrageDepart;
	private final double kilometrageArrivee;
	private final Limousine limousine;

	// Constructeur
	public Trajet(String villeDepart, String villeArrivee, double kilometrageDepart, double kilometrageArrivee,
				  Limousine listeLimosine) {

		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.kilometrageDepart = kilometrageDepart;
		this.kilometrageArrivee = kilometrageArrivee;
		this.limousine = listeLimosine;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public Limousine getLimousine() {
		return limousine;
	}

	// Getter
	public String getLimousine_Trajet() {
		return limousine.getImmatriculation_Couleur();
	}

	public double getKilometrageDepart() {
		return kilometrageDepart;
	}

	public double getKilometrageArrivee() {
		return kilometrageArrivee;
	}

	/*************************************************/

	// Methode d'ecriture
	public String toString() {
		return "Depart: " + villeDepart + "\nArrivee: " + villeArrivee + "\nKilometrage de depart: "
				+ kilometrageDepart + "\nKilometrage d'arrivee: " + kilometrageArrivee + "\nLimousine reservee: ["
				+ limousine + "]" + "\n----------------------------------------------------------------------";
	}
}
