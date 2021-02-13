package Application;

public class Fournisseur {
	private String name;
	private int quantityLimousineFourni;

	public Fournisseur(String name, int quantityLimousineFourni) {
		this.name = name;
		this.quantityLimousineFourni = quantityLimousineFourni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityLimousineFourni() {
		return quantityLimousineFourni;
	}

	public void setQuantityLimousineFourni(int quantityLimousineFourni) {
		this.quantityLimousineFourni = quantityLimousineFourni;
	}
	public double depense(double montantLimousine) {
		return quantityLimousineFourni * montantLimousine;
	}


	public String toString() {
		Limousine.nombreLimousine += quantityLimousineFourni;
		String output = "Le Fournisseur " + name + " vient de contribuer avec " + quantityLimousineFourni
				+ " Limousines";
		return output;
	}
}
