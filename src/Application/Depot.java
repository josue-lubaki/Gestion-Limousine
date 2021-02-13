package Application;

public class Depot {
	private int getQuantityAcceptable;
	private double budget;
	public double getBudget() {
		return budget;
	}

	public void setBudget(int montant_Total) {
		this.budget += montant_Total;
	}

	public int getQuantityAcceptable() {
		return getQuantityAcceptable;
	}

	public void setQuantityAccept(int quantityAccept) {
		this.getQuantityAcceptable = quantityAccept;
	}

	//prix de loumousine(Ex : 2000 dollars) * Nombre de Limousine(Limousines.txt contient 20 limousines)
	public double montant_Total(double budgetDepense) {
		return budgetDepense * Limousine.getNombreLimousine();
	}

	// CONNAITRE LE NOMBRE DE LIMOUSINE DU DEPOT
	public int nbreLimousine() {
		Fournisseur four = new Fournisseur("",0);
		// Incrementation du nombre de Limousines lorsqu'un collaborateur contribue avec
		// des Limousines
		Limousine.nombreLimousine += four.getQuantityLimousineFourni();
		return Limousine.nombreLimousine;
	}

	public String toString() {
		//Exemple : Sachant qu'une limousine a couté 2000 Dollars
		budget = montant_Total(2000);
		return "Considerant que chaque Limousine a coûté à la compagnie 2000 Dollars\n"
				+ "La compagnie aurait depensé : " + getBudget() + " Dollars. "
				+ "\nPuisque La compagnie possède actuellement " + Limousine.getNombreLimousine() + " Limousines\n";
	}
}
