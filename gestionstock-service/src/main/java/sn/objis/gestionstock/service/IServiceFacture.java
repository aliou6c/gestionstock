package sn.objis.gestionstock.service;

import sn.objis.gestionstock.domaine.Facture;

public interface IServiceFacture extends IServiceGenerique<Facture> {
	public Facture findByNumFacture(String numFacture);

}
