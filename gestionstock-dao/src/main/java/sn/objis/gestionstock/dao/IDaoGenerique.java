package sn.objis.gestionstock.dao;

import java.util.List;

public interface IDaoGenerique<T> {
	public void creer(T t);
	public void modifier(T t);
	public List<T> afficher();
	public void supprimer(T t);
	

}
