package sn.objis.gestionstock.service;

import java.util.List;

public interface IServiceGenerique<T> {
	
	public void create(T t);
	
	public List<T> read();
	
	public void modify(T t);
	
	public void delete(T t);


}
