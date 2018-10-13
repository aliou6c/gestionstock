package sn.objis.gestionstock.service;


import sn.objis.gestionstock.service.IServiceProduitImpl;
import sn.objis.gestionstock.domaine.Produit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProduitService {
	
	

	


	
				static IServiceProduitImpl serviceProduit;
				Produit produit;	

				@BeforeClass
				public static void init() {
					serviceProduit = new IServiceProduitImpl();
					System.out.println("Execution avant le lancement des Tests");
				}

				@Test
				public void testCreate() {
					serviceProduit.create(new Produit("prod10","designation du produit 10 ",6,"fourn3",8000,5,20));

				}

				@Test
				public void testModify() {
					serviceProduit.modify(new Produit("prod10","designation du produit 10",8,"fourn4",8000,5,20));
				}

				@Test
				public void testRead() {
					serviceProduit.read();
				}

				@Test
				public void testDelete() {
					serviceProduit.delete(new Produit("prod10","designation du produit 8",8,"fourn3",8000,5,20));
				}

				@Test
				public void testFindByCodeProduit() {
					serviceProduit.findByCodeProduit("prod4");
				}
				
				@AfterClass
				public static void apresTest() {
					System.out.println("Après execution des tests !");
				}


			}









