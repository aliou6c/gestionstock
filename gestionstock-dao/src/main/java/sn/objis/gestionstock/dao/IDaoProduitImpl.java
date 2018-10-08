package sn.objis.gestionstock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.gestionstock.domaine.Produit;
import sn.objis.gestionstock.utils.MySqlConnection;

public class IDaoProduitImpl implements IDaoProduit {
	//Obtention de l'unique instance de connexion à la base
		Connection conn = MySqlConnection.getInstanceConnection();

	/**
	 * permet d'inserer dans la base un produit
	 */
	@Override
	public void creer(Produit produit) {
		try {
			//Etape 1: creation de la zone de requete
			String sql = "INSERT INTO produit(codeProduit,designationProduit,rayon,fournisseur,prix,remise,stock) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			//Etape 2: Transmission des valeurs aux paramètres de la requete
			ps.setString(1, produit.getCodeProduit());
			ps.setString(2, produit.getDesignationProduit());
			ps.setInt(3, produit.getRayon());
			ps.setString(4, produit.getFournisseur());
			ps.setInt(5, produit.getPrix());
			ps.setInt(6, produit.getRemise());
			ps.setInt(7, produit.getStock());
			
			//Etape 3: execution de la requete
			ps.executeUpdate();

			System.out.println("Insertion dans la base réussie !");		

		} catch (SQLException e) {
			System.out.println(" Insertion échouée !");
			e.printStackTrace();
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
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// transmission des valeurs aux parametres de la requete
			ps.setString(1, produit.getCodeProduit());
			ps.setString(2, produit.getDesignationProduit());
			ps.setInt(3, produit.getRayon());
			ps.setString(4, produit.getFournisseur());
			ps.setInt(5, produit.getPrix());
			ps.setInt(6, produit.getRemise());
			ps.setInt(7, produit.getStock());
			
			// execution de la requete
			ps.executeUpdate();

			System.out.println(" Modification effectuée ! ");

		} catch (SQLException e) {
			System.out.println(" Echec de la mise à jour ! ");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * permet de lister tous les produits
	 */
	@Override
	public List<Produit> afficher() {
		List<Produit>listeProduit = new ArrayList<>();
		try {
			// creation de la zone de requete
			String sql = "SELECT * FROM produit ";
			Statement st = conn.createStatement();

			// execution de la requete
			ResultSet rs = st.executeQuery(sql);

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

			e.printStackTrace();
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
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// transmission de valeurs au parametre de la requete
			ps.setString(1, produit.getCodeProduit());
			
			//execution de la requete
			ps.executeUpdate();
			
			System.out.println("Produit supprimé de la base !");
		} catch (SQLException e) {
			System.out.println("cet Produit n'existe pas dans la base!");
			e.printStackTrace();
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
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, codeProduit);
			
			//execution de la requete
			ResultSet rs = ps.executeQuery();
			
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

				produit = new Produit(idProduitRecup, codeProduitRecup, designationProduitRecup, rayonRecup, fournisseurRecup, prixRecup, remiseRecup, stockRecup);

				if(produit != null) {
					System.out.println("Produit trouvé !");
				}				
			}

		} catch (SQLException e) {
			System.out.println("cet produit n'existe pas !");
			e.printStackTrace();
		}

		return produit;
	}

}
