package sn.objis.gestionstock.dao;

import sn.objis.gestionstock.dao.IDaoProduitImpl;
import sn.objis.gestionstock.domaine.Produit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProduitDao {
	
		static IDaoProduitImpl daoProduit;
		Produit produit;	

		@BeforeClass
		public static void init() {
			daoProduit = new IDaoProduitImpl();
			System.out.println("Execution avant le lancement des Tests");
		}

		@Test
		public void testCreer() {
			daoProduit.creer(new Produit("prod8","designation du produit 8",8,"fourn3",8000,5,20));

		}

		@Test
		public void testModifier() {
			daoProduit.modifier(new Produit(8, "prod9", "designation du produit 9",9,"fourn3",8000,5,15));
		}

		@Test
		public void testAfficher() {
			daoProduit.afficher();
		}

		@Test
		public void testSupprimer() {
			daoProduit.supprimer(new Produit("prod9", "designation du produit 9",9,"fourn3",8000,5,15));
		}

		@Test
		public void testRechercherParCodeProduit() {
			daoProduit.rechercherParCodeProduit("prod7");
		}
		
		@AfterClass
		public static void apresTest() {
			System.out.println("Après execution des tests !");
		}


	}



