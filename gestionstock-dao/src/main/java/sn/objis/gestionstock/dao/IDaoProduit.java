package sn.objis.gestionstock.dao;

import sn.objis.gestionstock.domaine.Produit;


public interface IDaoProduit extends IDaoGenerique<Produit> {
	public Produit rechercherParCodeProduit(String codeProduit);

}
