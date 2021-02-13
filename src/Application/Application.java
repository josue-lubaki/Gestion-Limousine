package Application;
/* DESCRIPTION **************************************************************************
 *
 * @Author : Josue Lubaki
 *
 * CLASSE APPLICATION contenant la methode main()
 ********************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
	static Scanner scan = new Scanner(System.in);

	static Depot depot = new Depot();
	static int choix;
	static String buffer;
	static boolean chaineIsEmptyVerification = false;

	// Initialisation des variables des objets chauffeurs
	static String nomChauffeur;
	static String prenomChauffeur;
	static String adresseChauffeur;
	static String numeroChauffeur;
	static int anneeEmbaucheChauffeur;

	// Initialisation des variables des objets limousines
	static String immatriculation;
	static String couleur;
	static int capaciteReservoir;

	// Initialisation des variables des objets Trajets
	static String villeDepart;
	static String villeArrivee;
	static int kilometrageDepart, kilometrageArrivee;
	static Limousine limousineReservee;
	static boolean arret = false;

	// Creation d'un objet compagnie et de ces variables d'instance
	static ArrayList<Chauffeur> chauffeurCompagnie = new ArrayList<>();
	static ArrayList<Limousine> limousineCompagnie = new ArrayList<>();
	static ArrayList<Trajet> trajetCompagnie = new ArrayList<>();
	static Compagnie compagnie = new Compagnie(chauffeurCompagnie, limousineCompagnie, trajetCompagnie);

	// La fonction main()
	public static void main(String[] args) {
		/* VERIFICATION DU NOMBRE D'ARGUMENT */
		/*if (args.length < 3) {
			// SANS ARGUMENTS, ON TERMINE LE PROGRAMME.
			System.out.println(String.format("Il manque %d arguments \nCOPIER LES 3 ARGUMENTS CI-DESSOUS :"
					+ "\n\n\"src\\Application\\Chauffeurs.txt\"\n\"src\\Application\\Limousines.txt\""
					+ "\n\"src\\Application\\Trajets.txt\"", 3 - args.length));
			return;
		}

		lireListeChauffeur(args[0]);
		lireListeLimousine(args[1]);
		listLireTrajet(args[2]);*/

		lireListeChauffeur("src\\Application\\Chauffeurs.txt");
		lireListeLimousine("src\\Application\\Limousines.txt");
		listLireTrajet("src\\Application\\Trajets.txt");


		try {
			while (!arret) {
				System.out.println("\n\t--Menu--");

				System.out.println("1- Limousines conduites par un chauffeur");
				System.out.println("2- Caracteristique de tous les trajets et des limousines utilisees");
				System.out.println("3- Ajouter un Fournisseur");
				System.out.println("4- Connaître le Nombre des Limousines de la Compagnie");
				System.out.println("5- Faire l'inventaire du Depot");
				System.out.println("0- Sortir");

				System.out.print("\nEntrez l'indice de votre choix: ");
				choix = scan.nextInt();
				buffer = scan.nextLine();

				switch (choix) {

					case 1: {
						System.out.println("\t--LIMOUSINES D'UN CHAUFFEUR--");
						listeLimousines_Chauffeur();
						break;
					}
					case 2: {
						System.out.println("\n\t--CARACTERISTIQUES TRAJETS--");
						afficherTrajet();
						break;
					}
					case 3 : {
						System.out.println("\n\t--AJOUT D'UN FOURNISSEUR--");
						ajout_Fournisseur();
						break;
					}

					case 4 : {
						System.out.println("\n\t--NOMBRE DE LIMOUSINE DE LA COMPAGNIE--");
						System.out.println("Nombre de Limousines : " + depot.nbreLimousine());
						break;
					}
					case 5 : {
						System.out.println("\n\t--FAIRE L'INVENTAIRE DU DEPOT--");
						System.out.println(depot);
						break;
					}
					case 0: {
						System.out.println("\n\t\t\t\t--A BIENTOT--");
						arret = true;
						break;
					}
					default:
						System.out.println("\n\tVeuillez entrer une indice correcte");
				}

			} // end while
		} catch (InputMismatchException e) {
			System.out.println("\nLes caractères saisis sont invalides, veuillez Redemarrer le programme");
		}
	}

	static void lireListeChauffeur(String fichier) {
		File myObj = new File(fichier);
		try (Scanner myReader = new Scanner(myObj)) {
			chaineIsEmptyVerification = false;
			while (myReader.hasNextLine() && !chaineIsEmptyVerification) {

				String data = myReader.nextLine();
				String[] data_split = data.split("\t");

				if (data.equals("")) {
					chaineIsEmptyVerification = true;
				}

				else {
					// Lever l'avertissement
					if (data_split.length < 4) {
						throw new FormatErroneSplitTable();
					} else {
						// je range les valeurs splitees dans les variables
						nomChauffeur = data_split[0];
						prenomChauffeur = data_split[1];
						anneeEmbaucheChauffeur = Integer.parseInt(data_split[2]);
						adresseChauffeur = data_split[3];
						// System.out.println("nom: "+nomChauffeur+" "+"prenom: "+prenomChauffeur+"
						// annee: "+anneeEmbaucheChauffeur+" adresse: "+adresseChauffeur);

						numeroChauffeur = Chauffeur.contructionNumeroEnregistrement(nomChauffeur, prenomChauffeur,
								anneeEmbaucheChauffeur);

						// je cree le numero du chauffeur

						ArrayList<Trajet> listeTrajet = new ArrayList<>();

						// je cree l'objet chauffeur
						Chauffeur chauffeur = new Chauffeur(nomChauffeur, prenomChauffeur, numeroChauffeur,
								anneeEmbaucheChauffeur, adresseChauffeur, listeTrajet);

						compagnie.ajouterChauffeurListe(chauffeur);

					}
				}

			}

			/*
			 * System.out.println("Chauffeur de la compagnie:\n"); for(Chauffeur liste:
			 * compagnie.getListeChauffeur() ) { System.out.println(liste); }
			 */
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (FormatErroneSplitTable e1) {
			e1.printStackTrace(System.out);
		}

	}

	static void lireListeLimousine(String fichier) {
		// Lecture du fichier
		File myObj = new File(fichier);
		try (Scanner myReader = new Scanner(myObj)) {
			chaineIsEmptyVerification = false;
			while (myReader.hasNextLine() && !chaineIsEmptyVerification) {
				String data = myReader.nextLine(); // On recupere la ligne courante
				String[] data_split = data.split("\t"); // On recupere chaque mot
				if (data.equals("")) {
					chaineIsEmptyVerification = true;
				} else {

					if (data_split.length != 3) {
						throw new FormatErroneSplitTable();
					} else {
						// je range les valeurs splitees dans les variables
						immatriculation = data_split[0];
						capaciteReservoir = Integer.parseInt(data_split[1]);
						couleur = data_split[2];
						// System.out.println("nom: "+immatriculation+" "+"reser: "+capaciteReservoir+"
						// couleur: "+couleur);

						Limousine limousine = new Limousine(immatriculation, capaciteReservoir, couleur);
						compagnie.ajouterLimosineListe(limousine);

					}
				}
			}

			// On affiche les limousines
			/*
			 * System.out.println("Limousine de la compagnie:\n"); for(Limousine liste:
			 * compagnie.getListeLimosine() ) { System.out.println(liste); }
			 */
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (FormatErroneSplitTable e1) {
			e1.printStackTrace(System.out);
		}

	}

	static void listLireTrajet(String fichier) {
		// Lecture du fichier
		File myObj = new File(fichier);
		try (Scanner myReader = new Scanner(myObj)) {
			chaineIsEmptyVerification = false;
			while (myReader.hasNextLine() && !chaineIsEmptyVerification) {
				String data = myReader.nextLine(); // On recupere la ligne courante
				String[] data_split = data.split("\t"); // On recupere chaque mot
				// je range les valeurs splitees dans les variables
				if (data.equals("")) {
					chaineIsEmptyVerification = true;
				} else {
					if (data_split.length != 6) {
						throw new FormatErroneSplitTable();
					} else {
						numeroChauffeur = data_split[0];
						villeDepart = data_split[1];
						villeArrivee = data_split[2];
						kilometrageDepart = Integer.parseInt(data_split[3]);
						kilometrageArrivee = Integer.parseInt(data_split[4]);
						immatriculation = data_split[5];

						limousineReservee = compagnie.limosineReservee(immatriculation);

						Trajet trajet = new Trajet(villeDepart, villeArrivee, kilometrageDepart, kilometrageArrivee,
								limousineReservee);

						Compagnie.rechercheChauffeur(numeroChauffeur).ajouterTrajetListe(trajet);

						compagnie.ajouterTrajetListe(trajet);
					}
				}
			}

			// On affiche les limousines
			/*
			 * System.out.println("Trajet de la compagnie:\n"); for(Trajet liste:
			 * compagnie.getListeTrajet() ) { System.out.println(liste); }
			 */
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (FormatErroneSplitTable e1) {
			e1.printStackTrace(System.out);
		}

	}

	static void listeLimousines_Chauffeur() {
		try {
			System.out.println("Liste chauffeurs");

			compagnie.afficher_Chauffeur_Numero_Nom();

			System.out.print("\nEntrer l'ID du Chauffeur de votre choix ( exemple : ManP12 ): ");

			buffer = scan.nextLine();

			Chauffeur agent = Compagnie.rechercheChauffeur(buffer);
			agent.getLimousine_Chauffeur();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("ce numero d'identification ne correspond à aucun Chauffeur");
		}
	}

	static void afficherTrajet() {
		System.out.println("Liste de trajets: ");
		System.out.println("----------------------------------------------------------------------");
		for (Trajet liste : compagnie.getListeTrajet()) {
			System.out.println(liste + "\n");
		}

	}

	static void ajout_Fournisseur() {
		System.out.println("Entrer le nom du Fournisseur");
		String nom = scan.nextLine();
		System.out.println("Entrer le nombre de Limousine contribuée");
		int nombre = scan.nextInt();
		// CAS DU FOURNISSEUR
		Fournisseur collaborateur = new Fournisseur(nom, nombre); // Instancier l'objet Fournisseur
		System.out.println(collaborateur);
	}
} // FIN APPLICATION
