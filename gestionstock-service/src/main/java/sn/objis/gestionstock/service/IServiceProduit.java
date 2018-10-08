package sn.objis.gestionstock.service;

import sn.objis.gestionstock.domaine.Produit;

public interface IServiceProduit extends IServiceGenerique<Produit> {
	public Produit findByCodeProduit(String codeProduit);

}
