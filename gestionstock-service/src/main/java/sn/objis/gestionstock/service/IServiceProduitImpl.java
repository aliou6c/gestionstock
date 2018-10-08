package sn.objis.gestionstock.service;

import java.util.List;

import sn.objis.gestionstock.dao.IDaoProduitImpl;
import sn.objis.gestionstock.domaine.Produit;

public class IServiceProduitImpl implements IServiceProduit {
	
	//couplage fort
	private IDaoProduitImpl daoProduit = new IDaoProduitImpl();
		

	@Override
	public void create(Produit produit) {
		daoProduit.creer(produit);
		
	}

	@Override
	public List<Produit> read() {
		
		return daoProduit.afficher();
	}

	@Override
	public void modify(Produit produit) {
		daoProduit.modifier(produit);
		
	}

	@Override
	public void delete(Produit produit) {
		daoProduit.supprimer(produit);
		
	}

	@Override
	public Produit findByCodeProduit(String codeProduit) {
		
		return daoProduit.rechercherParCodeProduit(codeProduit);
	}

}
