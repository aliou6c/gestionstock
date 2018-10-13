package sn.objis.gestionstock.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sn.objis.gestionstock.service.IServiceFactureImpl;
import sn.objis.gestionstock.domaine.Facture;

public class TestFactureService {
	
	static IServiceFactureImpl ServiceFacture;
	Facture facture;	

	@BeforeClass
	public static void init() {
		ServiceFacture = new IServiceFactureImpl();
		System.out.println("Execution avant le lancement des Tests");
	}

	@Test
	public void testCreate() {
		ServiceFacture.create(new Facture("fac8","prod5","facture produit 8",1000,10,10000));
		
	}

	@Test
	public void testModify() {
		ServiceFacture.modify(new Facture("fac2","prod5","facture produit 5",1000,10,10000));
	}

	@Test
	public void testRead() {
		ServiceFacture.read();
	}

	@Test
	public void testDelete() {
		ServiceFacture.delete(new Facture("fac2","prod5","facture produit 5",1000,10,10000));
	}

	@Test
	public void testFindByNumFacture() {
		ServiceFacture.findByNumFacture("fac2");
	}
	
	@AfterClass
	public static void apresTest() {
		System.out.println("Après execution des tests !");
	}


}









