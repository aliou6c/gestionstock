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
	private static String userDb= "root";
	private static String pwdDb= "";
	private static Connection conn= null;//l'unique instance de connexion à la base
	
	//Constructeur priv� pour blocquer la cr�ation d'instance de la classe
	public MySqlConnection(){
		super();
		
	}
	
	/**
	 * Cette methode retourne l'unique instance de connexion avec la base
	 * @return
	 * @throws IOException 
	 * @throws SecurityException 
	 * @throws SQLException 
	 */
	public static Connection getInstanceConnection() {
		Logger logger = Logger.getLogger("logger");
		try {
			 FileHandler fh= new FileHandler();

			 logger.addHandler(fh);
			if(conn==null) {// Aucune connexion avec la base
				conn=DriverManager.getConnection(url + "user=" + userDb + "&password=" +pwdDb);
				 
				 logger.log(Level.INFO, "Connexion établie avec la base");
				  
				
			}
		} catch (IOException e) {
			
			logger.log(Level.INFO, "Probleme de connexion !");
		}
		
		catch(SQLException e) {
			logger.log(Level.INFO, "echec de la connexion !");
		}
		finally {

		}
		return conn;
	}
	
		
	
}
