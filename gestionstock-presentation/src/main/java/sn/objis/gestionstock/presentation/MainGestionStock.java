package sn.objis.gestionstock.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import sn.objis.gestionstock.domaine.Facture;
import sn.objis.gestionstock.domaine.Produit;
import sn.objis.gestionstock.service.IServiceFactureImpl;
import sn.objis.gestionstock.service.IServiceProduitImpl;

public class MainGestionStock {

	public static void main(String[] args) {

		IServiceProduitImpl serviceProduit = new IServiceProduitImpl();
		IServiceFactureImpl serviceFacture = new IServiceFactureImpl();

		Scanner sc = new Scanner(System.in);
		int choix;
		do {
			System.out.println("            Gestion Stock       ");
			System.out.println(
					"*********************************************************************************************");
			System.out.println("Veuillez choisir une option du menu suivant : ");
			System.out.println();
			System.out.println("       1 - GESTION DES PRODUITS ");
			System.out.println("       2 - GESTION DES FACTURES ");
			System.out.println(" 	4 - QUITTER L'APPLICATION ");
			System.out.println();
			System.out.println(
					"*******************************************************************************************");
			System.out.println("Tapez votre choix ici ===>: ");
			choix = sc.nextInt();
			sc.nextLine();
			switch (choix) {
			case 1:
				System.out.println(
						"-----------------MENU GESTION DES PRODUITS ----------------------------------------- ");
				System.out.println("	1:   créer un produit	");
				System.out.println("	2:   mettre à jour un produit 	");
				System.out.println("	3:   supprimer un produit	");
				System.out.println("	4:   rechercher un produit par sa reférence	");
				System.out.println("   5:   lister tous les produits ");
				System.out.println("	6:   quitter	");
				System.out.println();
				System.out.println(
						"******************************************************************************************");
				System.out.println("Tapez votre choix ici : ");
				int choix_produit = sc.nextInt();
				sc.nextLine();
				switch (choix_produit) {
				case 1:
					System.out.println("entrer le code du produit");
					String codeProduit = sc.nextLine();
					System.out.println("Donner la désignation du produit");
					String designationProduit = sc.nextLine();
					System.out.println("Indiquez le rayon du produit");
					int rayon = sc.nextInt();
					System.out.println("Indiquez le fournisseur pour cet produit");
					String fournisseur = sc.nextLine();
					System.out.println("Donnez le prix du produit");
					int prix = sc.nextInt();
					System.out.println("Indiquez la remise sur cet produit");
					int remise = sc.nextInt();
					System.out.println("Renseigner la quantite en stock de cet produit");
					int stock = sc.nextInt();

					Produit nouveauProduit = new Produit(codeProduit, designationProduit, rayon, fournisseur, prix,
							remise, stock);
					serviceProduit.create(nouveauProduit);

					break;
				case 2:
					System.out.println("saisir le code du produit à mettre à jour");
					String codeProduitAModifier = sc.nextLine();
					Produit produitAModifier = serviceProduit.findByCodeProduit(codeProduitAModifier);
					if (produitAModifier == null) {
						System.out.println("Cet Produit n'existe pas !");

					} else {
						System.out.println("entrer la nouvelle désignation du produit");
						String nouvelleDesignationProduit = sc.nextLine();
						sc.nextLine();
						System.out.println("entrer le nouvel rayon du produit");
						int nouvelRayon = sc.nextInt();
						System.out.println("indiquer le nouvel  fournisseur du produit");
						String nouveauFournisseur = sc.nextLine();
						System.out.println("entrer le nouveau prix de cet produit");
						int nouveauPrix = sc.nextInt();
						System.out.println("Indiquer la nouvelle remise de cet produit");
						int nouvelleRemise = sc.nextInt();
						System.out.println("indiquer la nouvelle quantité en stock");
						int nouveauStock = sc.nextInt();

						produitAModifier.setCodeProduit(codeProduitAModifier);
						produitAModifier.setDesignationProduit(nouvelleDesignationProduit);
						produitAModifier.setRayon(nouvelRayon);
						produitAModifier.setFournisseur(nouveauFournisseur);
						produitAModifier.setPrix(nouveauPrix);
						produitAModifier.setRemise(nouvelleRemise);
						produitAModifier.setStock(nouveauStock);

						serviceProduit.modify(produitAModifier);

					}
					break;
				case 3:
					System.out.println("saisir le code du produit à supprimer");
					String codeProduitASupp = sc.nextLine();
					Produit produitASupprimer = serviceProduit.findByCodeProduit(codeProduitASupp);

					if (produitASupprimer == null) {
						System.out.println("cet produit n'existe pas !");
					} else {
						serviceProduit.delete(produitASupprimer);
					}
					break;
				case 4:
					System.out.println("saisir le code du produit à rechercher");
					String codeProduitARechercher = sc.nextLine();
					Produit produitARechercher = serviceProduit.findByCodeProduit(codeProduitARechercher);
					if (produitARechercher == null) {
						System.out.println("cet produit n'existe pas");
					} else {
						System.out.println(produitARechercher);
					}
					break;
				case 5:
					List<Produit> listeProduit = serviceProduit.read();

					if (listeProduit != null && listeProduit.size() > 0) {
						Iterator<Produit> iteratorProduit = listeProduit.iterator();
						while (iteratorProduit.hasNext()) {
							Produit produit = iteratorProduit.next();
							System.out.println(produit);
							System.out.println(
									"-----------------------------------------------------------------------------");
						}
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("faire le bon choix");
					break;
				}
				break;
			case 3:
				System.out.println(
						"-----------------  MENU GESTION DES FACTURES ---------------------------------------------- ");
				System.out.println("	1:   creer une facture	");
				System.out.println("	2:   mettre à jour les données d'une facture	");
				System.out.println("	3:   supprimer une facture	");
				System.out.println("	4:   rechercher une facture par son numéro facture	");
				System.out.println("	5:   lister toutes les factures ");
				System.out.println("	6:   quitter	");
				System.out.println();
				System.out.println(
						"******************************************************************************************");
				System.out.println("Tapez votre choix ici : ");
				int choix_facture = sc.nextInt();
				sc.nextLine();
				switch (choix_facture) {
				case 1:
					System.out.println("Entrer le numero de la facture");
					String numFacture = sc.nextLine();
					System.out.println("Donner le code du produit");
					String codeProduit = sc.nextLine();
					System.out.println("entrer la reference de la facture ");
					String referenceFacture = sc.nextLine();
					System.out.println("entrer le prix de vente du produit ");
					int prixDeVente = sc.nextInt();
					System.out.println("entrer la quantité de produit livré");
					int stockSortie = sc.nextInt();
					System.out.println("entrer le montant total de la facture ");
					int totalFacture = sc.nextInt();

					Facture nouvelleFacture = new Facture(numFacture, codeProduit, referenceFacture, prixDeVente,
							stockSortie, totalFacture);

					serviceFacture.create(nouvelleFacture);

					break;
				case 2:
					System.out.println("saisir le numéro de la facture à mettre à jour");
					String numFacture1 = sc.nextLine();
					Facture factureAModifier = serviceFacture.findByNumFacture(numFacture1);
					if (factureAModifier == null) {
						System.out.println("cette facture n'existe pas !");

					} else {

						System.out.println("entrer le nouveau de la facture ");
						sc.nextLine();
						String nouvelleNumFacture = sc.nextLine();
						System.out.println("taper le nouvel code produit");
						String nouveauCodeProduit = sc.nextLine();
						System.out.println("entrer la nouvelle reference de la facture");
						String nouvelleReferenceFacture = sc.nextLine();
						System.out.println("Entrer le nouvel prix de vente ");
						int nouvelPrixDeVente = sc.nextInt();
						System.out.println("enter la nouvelle quantite livrée");
						int nouvelStockSortie = sc.nextInt();
						System.out.println("Entrer le nouvel montant de la facture ");
						int nouvelTotalFacture = sc.nextInt();

						factureAModifier.setNumFacture(nouvelleNumFacture);
						factureAModifier.setCodeProduit(nouveauCodeProduit);
						factureAModifier.setReferenceFacture(nouvelleReferenceFacture);
						factureAModifier.setPrixDeVente(nouvelPrixDeVente);
						factureAModifier.setStockSortie(nouvelStockSortie);
						factureAModifier.setTotalFacture(nouvelTotalFacture);

						serviceFacture.modify(factureAModifier);

					}
					break;
				case 3:
					System.out.println("saisir le numéro de la facture à supprimer");
					String numFactureAsupp = sc.nextLine();
					Facture factureASupprimer = serviceFacture.findByNumFacture(numFactureAsupp);
					if (factureASupprimer == null) {
						System.out.println("cette facture n'existe pas !");
					} else {
						serviceFacture.delete(factureASupprimer);

					}
					break;
				case 4:
					System.out.println("saisir le numéro de la facture à rechercher");
					String numFactureARechercher = sc.nextLine();
					Facture factureARechercher = serviceFacture.findByNumFacture(numFactureARechercher);
					if (factureARechercher == null) {
						System.out.println("cette facture n'existe pas !");
					} else {
						System.out.println(factureARechercher);
						System.out.println("facture trouvée !");
					}
					break;
				case 5:
					List<Facture> listeFacture = serviceFacture.read();

					if (listeFacture != null && listeFacture.size() > 0) {
						Iterator<Facture> iteratorFacture = listeFacture.iterator();
						while (iteratorFacture.hasNext()) {
							Facture facture = iteratorFacture.next();
							System.out.println(facture);
							System.out.println(
									"---------------------------------------------------------------------------------");
						}
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("faire le bon choix");
					break;
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("faire le bon choix");
				break;
			}

		} while (choix != 4);

		sc.close();

	}

}
