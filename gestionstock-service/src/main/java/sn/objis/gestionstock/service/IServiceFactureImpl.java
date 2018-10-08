package sn.objis.gestionstock.service;

import java.util.List;

import sn.objis.gestionstock.dao.IDaoFactureImpl;
import sn.objis.gestionstock.domaine.Facture;

public class IServiceFactureImpl implements IServiceFacture {
	//couplage fort
	private IDaoFactureImpl daoFacture = new IDaoFactureImpl();

	@Override
	public void create(Facture facture) {
		daoFacture.creer(facture);
		
	}

	@Override
	public List<Facture> read() {
		
		return daoFacture.afficher();
	}

	@Override
	public void modify(Facture facture) {
		daoFacture.modifier(facture);
		
	}

	@Override
	public void delete(Facture facture) {
		daoFacture.supprimer(facture);
		
	}

	@Override
	public Facture findByNumFacture(String numFacture) {
		
		return daoFacture.rechercherParNumFacture(numFacture);
	}

}
