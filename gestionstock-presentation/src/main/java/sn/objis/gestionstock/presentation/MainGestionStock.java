package sn.objis.gestionstock.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import sn.objis.gestionstock.domaine.Facture;
import sn.objis.gestionstock.domaine.Produit;
import sn.objis.gestionstock.service.IServiceFactureImpl;
import sn.objis.gestionstock.service.IServiceProduitImpl;

public class MainGestionStock {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("logger");

		IServiceProduitImpl serviceProduit = new IServiceProduitImpl();
		IServiceFactureImpl serviceFacture = new IServiceFactureImpl();

		Scanner sc = new Scanner(System.in);
		int choix;
		do {
			logger.log(Level.INFO,"            Gestion Stock       ");
			logger.log(Level.INFO,"*********************************************************************************************");		
			logger.log(Level.INFO,"Veuillez choisir une option du menu suivant : ");
			logger.log(Level.INFO,"");
			logger.log(Level.INFO," 1 - GESTION DES PRODUITS ");
			logger.log(Level.INFO," 2 - GESTION DES FACTURES ");
			logger.log(Level.INFO," 4 - QUITTER L'APPLICATION ");
			logger.log(Level.INFO,"");
			logger.log(Level.INFO,"*******************************************************************************************");
			logger.log(Level.INFO,"Tapez votre choix ici ===>: ");
			choix = sc.nextInt();
			sc.nextLine();
			switch(choix) {
			case 1:
				logger.log(Level.INFO,"-----------------  MENU GESTION DES PRODUITS ----------------------------------------- ");
				logger.log(Level.INFO,"	1:   créer un produit	");
				logger.log(Level.INFO,"	2:   mettre à jour un produit 	");
				logger.log(Level.INFO,"	3:   supprimer un produit	");
				logger.log(Level.INFO,"	4:   rechercher un produit par sa reférence	");
				logger.log(Level.INFO,"	5:   lister tous les produits ");
				logger.log(Level.INFO,"	6:   quitter	");
				logger.log(Level.INFO,"");
				logger.log(Level.INFO,"******************************************************************************************");		
				logger.log(Level.INFO,"Tapez votre choix ici : ");
				int choix_produit = sc.nextInt();
				sc.nextLine();
				switch (choix_produit) {
				case 1:
					logger.log(Level.INFO,"entrer le code du produit");
					String codeProduit = sc.nextLine();
					logger.log(Level.INFO,"Donner la désignation du produit");
					String designationProduit = sc.nextLine();
					logger.log(Level.INFO,"Indiquez le rayon du produit");
					int rayon = sc.nextInt();
					logger.log(Level.INFO,"Indiquez le fournisseur pour cet produit");
					String fournisseur = sc.nextLine();
					logger.log(Level.INFO,"Donnez le prix du produit");
					int prix = sc.nextInt();
					logger.log(Level.INFO,"Indiquez la remise sur cet produit");
					int remise = sc.nextInt();
					logger.log(Level.INFO,"Renseigner la quantite en stock de cet produit");
					int stock = sc.nextInt();

					Produit nouveauProduit = new Produit(codeProduit, designationProduit, rayon, fournisseur, prix, remise, stock);
					serviceProduit.create(nouveauProduit);

					break;
				case 2:
					logger.log(Level.INFO,"saisir le code du produit à mettre à jour");
					String codeProduitAModifier = sc.nextLine();	
					Produit produitAModifier =serviceProduit.findByCodeProduit(codeProduitAModifier);
					if(produitAModifier == null) {
						logger.log(Level.INFO,"Cet Produit n'existe pas !");

					}else {
						logger.log(Level.INFO,"entrer la nouvelle désignation du produit");
						String nouvelleDesignationProduit = sc.nextLine();
						sc.nextLine();						
						logger.log(Level.INFO,"entrer le nouvel rayon du produit");
						int nouvelRayon = sc.nextInt();				
						logger.log(Level.INFO,"indiquer le nouvel  fournisseur du produit");
						String nouveauFournisseur = sc.nextLine();	
						logger.log(Level.INFO,"entrer le nouveau prix de cet produit");
						int nouveauPrix = sc.nextInt();
						logger.log(Level.INFO,"Indiquer la nouvelle remise de cet produit");
						int nouvelleRemise = sc.nextInt();
						logger.log(Level.INFO,"indiquer la nouvelle quantité en stock");
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
					logger.log(Level.INFO,"saisir le code du produit à supprimer");
					String codeProduitASupp = sc.nextLine();
					Produit produitASupprimer =serviceProduit.findByCodeProduit(codeProduitASupp);

					if(produitASupprimer == null ) {
						logger.log(Level.INFO,"cet produit n'existe pas !");
					}else {
						serviceProduit.delete(produitASupprimer);
					}
					break;
				case 4:
					logger.log(Level.INFO,"saisir le code du produit à rechercher");
					String codeProduitARechercher = sc.nextLine();
					Produit produitARechercher = serviceProduit.findByCodeProduit(codeProduitARechercher);
					if(produitARechercher == null) {
						logger.log(Level.INFO,"cet produit n'existe pas");
					}else {
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
							logger.log(Level.INFO,"-----------------------------------------------------------------------------");
						} 
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					logger.log(Level.INFO,"faire le bon choix");
					break;
				}			
				break;
			case 3:
				logger.log(Level.INFO,"-----------------  MENU GESTION DES FACTURES ---------------------------------------------- ");
				logger.log(Level.INFO,"	1:   creer une facture	");
				logger.log(Level.INFO,"	2:   mettre à jour les données d'une facture	");
				logger.log(Level.INFO,"	3:   supprimer une facture	");
				logger.log(Level.INFO,"	4:   rechercher une facture par son numéro facture	");
				logger.log(Level.INFO,"	5:   lister toutes les factures ");
				logger.log(Level.INFO,"	6:   quitter	");
				logger.log(Level.INFO,"");
				logger.log(Level.INFO,"******************************************************************************************");		
				logger.log(Level.INFO,"Tapez votre choix ici : ");
				int choix_facture = sc.nextInt();
				sc.nextLine();
				switch (choix_facture) {		
				case 1:
					logger.log(Level.INFO,"Entrer le numero de la facture");
					String numFacture = sc.nextLine();
					logger.log(Level.INFO,"Donner le code du produit");
					String codeProduit = sc.nextLine();
					logger.log(Level.INFO,"entrer la reference de la facture ");
					String referenceFacture = sc.nextLine();		
					logger.log(Level.INFO,"entrer le prix de vente du produit ");
					int prixDeVente = sc.nextInt();
					logger.log(Level.INFO,"entrer la quantité de produit livré");
					int stockSortie = sc.nextInt();					
					logger.log(Level.INFO,"entrer le montant total de la facture ");
					int totalFacture = sc.nextInt();
										
					Facture nouvelleFacture = new Facture(numFacture, codeProduit, referenceFacture, prixDeVente, stockSortie, totalFacture);
					
					serviceFacture.create(nouvelleFacture);

					break;
				case 2:
					logger.log(Level.INFO,"saisir le numéro de la facture à mettre à jour");
					String numFacture1 = sc.nextLine();
					Facture factureAModifier =serviceFacture.findByNumFacture(numFacture1);
					if(factureAModifier == null) {
						System.out.println("cette facture n'existe pas !");

					}else {

						logger.log(Level.INFO,"entrer le nouveau de la facture ");
						sc.nextLine();
						String nouvelleNumFacture = sc.nextLine();
						logger.log(Level.INFO,"taper le nouvel code produit");
						String nouveauCodeProduit = sc.nextLine();
						logger.log(Level.INFO,"entrer la nouvelle reference de la facture");
						String nouvelleReferenceFacture = sc.nextLine();
						logger.log(Level.INFO,"Entrer le nouvel prix de vente ");
						int nouvelPrixDeVente = sc.nextInt();
						logger.log(Level.INFO,"enter la nouvelle quantite livrée");
						int nouvelStockSortie = sc.nextInt();
						logger.log(Level.INFO,"Entrer le nouvel montant de la facture ");
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
					logger.log(Level.INFO,"saisir le numéro de la facture à supprimer");
					String numFactureAsupp = sc.nextLine();
					Facture factureASupprimer =serviceFacture.findByNumFacture(numFactureAsupp);
					if(factureASupprimer ==null ) {
						logger.log(Level.INFO,"cette facture n'existe pas !");
					}else {
						serviceFacture.delete(factureASupprimer);
						
					}
					break;
				case 4:
					logger.log(Level.INFO,"saisir le numéro de la facture à rechercher");
					String numFactureARechercher = sc.nextLine();
					Facture factureARechercher = serviceFacture.findByNumFacture(numFactureARechercher);
					if(factureARechercher == null) {
						logger.log(Level.INFO,"cette facture n'existe pas !");
					}else {
						System.out.println(factureARechercher);
						logger.log(Level.INFO,"facture trouvée !");
					}
					break;
				case 5:
					List<Facture> listeFacture = serviceFacture.read();

					if (listeFacture != null && listeFacture.size() > 0) {
						Iterator<Facture> iteratorFacture = listeFacture.iterator();
						while (iteratorFacture.hasNext()) {
							Facture facture = iteratorFacture.next();
							System.out.println(facture);
							logger.log(Level.INFO,"---------------------------------------------------------------------------------");
						} 
					}
					break;
				case 6:
					System.exit(0);
					break;
				default:
					logger.log(Level.INFO,"faire le bon choix");
					break;
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				logger.log(Level.INFO,"faire le bon choix");
				break;
			}

		}while(choix!=4);	
			
		sc.close();	

	}

	}


