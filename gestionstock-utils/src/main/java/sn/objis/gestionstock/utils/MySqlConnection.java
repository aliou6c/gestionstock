package sn.objis.gestionstock.utils;
/**
 * Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les accès à la base en une et une seule instance de
 * connexion
 * @author alioucisse
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	private static String url="jdbc:mysql://localhost/bd_gestionstock?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userDb="root";
	private static String pwdDb="";
	private static Connection conn= null;//l'unique instance de connexion à la base
	
	//Constructeur priv� pour blocquer la cr�ation d'instance de la classe
	private MySqlConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Cette methode retourne l'unique instance de connexion avec la base
	 * @return
	 */
	public static Connection getInstanceConnection(){
		try {
			if(conn==null) {// Aucune connexion avec la base
				conn=DriverManager.getConnection(url, userDb, pwdDb);
				System.out.println("Connexion établie avec la base");
			}
		} catch (SQLException e) {
			System.out.println("Problème de connexion");
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
