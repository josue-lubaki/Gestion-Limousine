package Application;

/* DESCRIPTION **************************************************************************
 *	
 * @Author : Josue Lubaki
 * 
 * CLASSE FORMATERRONESPLITABLE permet de gérer toutes erreurs de format lors de la lecture des fichiers (Les nombres de colonne requises)
 ********************************************************************************/
public class FormatErroneSplitTable extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormatErroneSplitTable() {
		super("Le format d'entree d'une ligne est incorrect");
	}

	
}