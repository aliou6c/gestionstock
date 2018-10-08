package sn.objis.gestionstock.dao;

import sn.objis.gestionstock.domaine.Facture;

public interface IDaoFacture extends IDaoGenerique<Facture> {
	public Facture rechercherParNumFacture(String numFacture);

}
