package sn.objis.gestionstock.dao;

import sn.objis.gestionstock.dao.IDaoFactureImpl;
import sn.objis.gestionstock.domaine.Facture;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestFactureDao {
	
			static IDaoFactureImpl daoFacture;
			Facture facture;	

			@BeforeClass
			public static void init() {
				daoFacture = new IDaoFactureImpl();
				System.out.println("Execution avant le lancement des Tests");
			}

			@Test
			public void testCreer() {
				daoFacture.creer(new Facture("fac8","prod5","facture produit 8",1000,10,10000));

			}

			@Test
			public void testModifier() {
				daoFacture.modifier(new Facture("fac2","prod5","facture produit 5",1000,10,10000));
			}

			@Test
			public void testAfficher() {
				daoFacture.afficher();
			}

			@Test
			public void testSupprimer() {
				daoFacture.supprimer(new Facture("fac2","prod5","facture produit 5",1000,10,10000));
			}

			@Test
			public void testRechercherParNumFacture() {
				daoFacture.rechercherParNumFacture("fac2");
			}
			
			@AfterClass
			public static void apresTest() {
				System.out.println("Après execution des tests !");
			}


		}






