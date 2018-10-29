package sn.objis.gestionstock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sn.objis.gestionstock.domaine.Produit;
import sn.objis.gestionstock.utils.MySqlConnection;

public class IDaoProduitImpl implements IDaoProduit {
	PreparedStatement preparedStatement2 = null;
	Statement st = null;
	ResultSet rs = null;
	Logger logger = Logger.getLogger("logger");

	// Obtention de l'unique instance de connexion à la base
	Connection conn = MySqlConnection.getInstanceConnection();

	/**
	 * permet d'inserer dans la base un produit
	 */
	@Override
	public void creer(Produit produit) {
		try {
			// Etape 1: creation de la zone de requete
			String sql = "INSERT INTO produit(codeProduit,designationProduit,rayon,fournisseur,prix,remise,stock) VALUES (?,?,?,?,?,?)";
			preparedStatement2 = conn.prepareStatement(sql);

			// Etape 2: Transmission des valeurs aux paramètres de la requete
			preparedStatement2.setString(1, produit.getCodeProduit());
			preparedStatement2.setString(2, produit.getDesignationProduit());
			preparedStatement2.setInt(3, produit.getRayon());
			preparedStatement2.setString(4, produit.getFournisseur());
			preparedStatement2.setInt(5, produit.getPrix());
			preparedStatement2.setInt(6, produit.getRemise());
			preparedStatement2.setInt(7, produit.getStock());

			// Etape 3: execution de la requete
			preparedStatement2.executeUpdate();

			System.out.println("Insertion dans la base réussie !");

		} catch (SQLException e) {
			logger.log(Level.INFO, " Insertion échouée !");

		}

	}

	/**
	 * permet de modifier un produit
	 */

	@Override
	public void modifier(Produit produit) {
		try {
			// creation de la zone de requete
			String sql = " UPDATE produit SET codeProduit = ?, designationProduit = ?, rayon = ?,fournisseur = ?,prix=?,remise=?,stock=? WHERE codeProduit = ? ";
			preparedStatement2 = conn.prepareStatement(sql);

			// transmission des valeurs aux parametres de la requete
			preparedStatement2.setString(1, produit.getCodeProduit());
			preparedStatement2.setString(2, produit.getDesignationProduit());
			preparedStatement2.setInt(3, produit.getRayon());
			preparedStatement2.setString(4, produit.getFournisseur());
			preparedStatement2.setInt(5, produit.getPrix());
			preparedStatement2.setInt(6, produit.getRemise());
			preparedStatement2.setInt(7, produit.getStock());

			// execution de la requete
			preparedStatement2.executeUpdate();

			System.out.println(" Modification effectuée ! ");

		} catch (SQLException e) {
			logger.log(Level.INFO, " Echec de la mise à jour ! ");

		}

	}

	/**
	 * permet de lister tous les produits
	 */
	@Override
	public List<Produit> afficher() {
		List<Produit> listeProduit = new ArrayList<>();
		try {
			// creation de la zone de requete
			String sql = "SELECT * FROM produit ";
			st = conn.createStatement();

			// execution de la requete
			rs = st.executeQuery(sql);

			// traitement du resultat de la requete
			while (rs.next()) {
				Produit produit = new Produit();
				produit.setIdProduit(rs.getInt("idProduit"));
				produit.setCodeProduit(rs.getString("codeProduit"));
				produit.setDesignationProduit(rs.getString("designationProduit"));
				produit.setRayon(rs.getInt("rayon"));
				produit.setFournisseur(rs.getString("fournisseur"));
				produit.setPrix(rs.getInt("prix"));
				produit.setRemise(rs.getInt("remise"));
				produit.setStock(rs.getInt("stock"));

				listeProduit.add(produit);
			}
		} catch (SQLException e) {

			logger.log(Level.INFO, "echec lors de l'ajout du produit");
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				logger.log(Level.INFO, "Echec lors de la création du produit");
			}
		}
		return listeProduit;
	}

	/**
	 * permet de supprimer un produit à partir de son code produit
	 */
	@Override
	public void supprimer(Produit produit) {
		try {
			// creation de la zone de requete
			String sql = "DELETE FROM produit WHERE codeProduit = ?";
			preparedStatement2 = conn.prepareStatement(sql);

			// transmission de valeurs au parametre de la requete
			preparedStatement2.setString(1, produit.getCodeProduit());

			// execution de la requete
			preparedStatement2.executeUpdate();

			System.out.println("Produit supprimé de la base !");
		} catch (SQLException e) {
			logger.log(Level.INFO, "cet Produit n'existe pas dans la base!");

		}

	}

	/**
	 * permet de retrouver un produit quelconque à partir de son code produit
	 */

	@Override
	public Produit rechercherParCodeProduit(String codeProduit) {
		Produit produit = null;
		try {
			// creation de la zone de requete
			String sql = "SELECT * FROM produit WHERE codeProduit = ? ";
			preparedStatement2 = conn.prepareStatement(sql);

			preparedStatement2.setString(1, codeProduit);

			// execution de la requete
			rs = preparedStatement2.executeQuery();

			// traitement du resultat de la requete
			while (rs.next()) {
				int idProduitRecup = rs.getInt("idProduit");
				String codeProduitRecup = rs.getString("codeProduit");
				String designationProduitRecup = rs.getString("designationProduit");
				int rayonRecup = rs.getInt("rayon");
				String fournisseurRecup = rs.getString("fournisseur");
				int prixRecup = rs.getInt("prix");
				int remiseRecup = rs.getInt("remise");
				int stockRecup = rs.getInt("stock");

				produit = new Produit(idProduitRecup, codeProduitRecup, designationProduitRecup, rayonRecup,
						fournisseurRecup, prixRecup, remiseRecup, stockRecup);

				if (produit != null) {
					logger.log(Level.INFO,"Produit trouvé !");
				}
			}

		} catch (SQLException e) {
			logger.log(Level.INFO, "cet produit n'existe pas !");

		}
		finally {
			try {
				preparedStatement2.close();
				rs.close();
				
			} catch (SQLException e) {
				
				logger.log(Level.INFO, "echec fermeture de resultset");
			}
		}

		return produit;
	}

}
