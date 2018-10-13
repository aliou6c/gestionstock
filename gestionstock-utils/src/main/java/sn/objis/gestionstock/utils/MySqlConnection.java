package sn.objis.gestionstock.utils;
/**
 * Cette classe met en oeuvre le design pattern singleton
 * elle permet de restreindre les accès à la base en une et une seule instance de
 * connexion
 * @author alioucisse
 *
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection {
	
	private static String url="jdbc:mysql://localhost/bd_gestionstock?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userDb="root";
	private static String pwdDb="";
	private static Connection conn= null;//l'unique instance de connexion à la base
	
	//Constructeur priv� pour blocquer la cr�ation d'instance de la classe
	private MySqlConnection() {
		super();
		
	}
	/**
	 * Cette methode retourne l'unique instance de connexion avec la base
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws SQLException 
	 */
	public static Connection getInstanceConnection() throws SecurityException, IOException, SQLException{
		Logger logger = Logger.getLogger("logger");
		try {
			 FileHandler fh= new FileHandler();

			 logger.addHandler(fh);
			if(conn==null) {// Aucune connexion avec la base
				conn=DriverManager.getConnection(url, userDb, pwdDb);
				 
				 logger.log(Level.INFO, "Connexion établie avec la base");
				  
				//System.out.println("Connexion établie avec la base");
			}
		} catch (IOException e) {
			//System.out.println("Problème de connexion");
			//e.printStackTrace();
			logger.log(Level.INFO, "Probleme de connexion !");
		}
		catch(SecurityException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
