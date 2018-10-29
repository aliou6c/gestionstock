package sn.objis.gestionstock.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.gestionstock.domaine.Facture;
import sn.objis.gestionstock.utils.MySqlConnection;

public class IDaoFactureImpl implements IDaoFacture {
	PreparedStatement preparedStatement1 = null;

	// Obtention de l'unique instance de connexion à la base
	Connection conn = MySqlConnection.getInstanceConnection();

	/**
	 * permet d'inserer dans la base une facture
	 */
	@Override
	public void creer(Facture facture) {

		try {
			// Etape 1: creation de la zone de requete
			String sql = "INSERT INTO facture(numFacture,codeProduit,referenceFacture,prixDeVente,stockSortie,totalFacture) VALUES (?,?,?,?,?,?)";
			 preparedStatement1 = conn.prepareStatement(sql);

			// Etape 2: Transmission des valeurs aux paramètres de la requete
			preparedStatement1.setString(1, facture.getNumFacture());
			preparedStatement1.setString(2, facture.getCodeProduit());
			preparedStatement1.setString(3, facture.getReferenceFacture());
			preparedStatement1.setInt(4, facture.getPrixDeVente());
			preparedStatement1.setInt(5, facture.getStockSortie());
			preparedStatement1.setInt(6, facture.getTotalFacture());

			// Etape 3: execution de la requete
			preparedStatement1.executeUpdate();

			System.out.println("Insertion dans la base réussie !");

		} catch (SQLException e) {
			System.out.println(" Insertion échouée !");
			e.printStackTrace();
		}

	}

	/**
	 * permet de modifier une facture à partir du numFacture
	 */

	@Override
	public void modifier(Facture facture) {
		try {
			// creation de la zone de requete
			String sql = " UPDATE facture SET numFacture = ?,codeProduit = ?, referenceFacture = ?, prixDeVente = ?,stockSortie = ?,totalFacture=? WHERE numFacture = ? ";
			 preparedStatement1 = conn.prepareStatement(sql);

			// transmission des valeurs aux parametres de la requete
			preparedStatement1.setString(1, facture.getNumFacture());
			preparedStatement1.setString(2, facture.getCodeProduit());
			preparedStatement1.setString(3, facture.getReferenceFacture());
			preparedStatement1.setInt(4, facture.getPrixDeVente());
			preparedStatement1.setInt(5, facture.getStockSortie());
			preparedStatement1.setInt(6, facture.getTotalFacture());

			// execution de la requete
			preparedStatement1.executeUpdate();

			System.out.println(" Modification effectuée ! ");

		} catch (SQLException e) {
			System.out.println(" Echec de la mise à jour ! ");
			e.printStackTrace();
		}

	}

	/**
	 * permet de lister toutes les factures
	 */

	@Override
	public List<Facture> afficher() {
		List<Facture> listeFacture = new ArrayList<>();
		Statement st = null;
		
		try {
			// creation de la zone de requete
			String sql = "SELECT * FROM facture ";
			 st = conn.createStatement();

			// execution de la requete
			ResultSet rs = st.executeQuery(sql);

			// traitement du resultat de la requete
			while (rs.next()) {
				Facture facture = new Facture();
				facture.setIdFacture(rs.getInt("idFacture"));
				facture.setNumFacture(rs.getString("numFacture"));
				facture.setCodeProduit(rs.getString("codeProduit"));
				facture.setReferenceFacture(rs.getString("referenceFacture"));
				facture.setPrixDeVente(rs.getInt("prixDeVente"));
				facture.setStockSortie(rs.getInt("stockSortie"));
				facture.setTotalFacture(rs.getInt("totalFacture"));

				listeFacture.add(facture);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listeFacture;
	}

	/**
	 * permet de supprimer une facture à partir du numero facture
	 */
	@Override
	public void supprimer(Facture facture) {
		try {
			// creation de la zone de requete
			String sql = "DELETE FROM facture WHERE numFacture = ?";
			 preparedStatement1 = conn.prepareStatement(sql);

			// transmission de valeurs au parametre de la requete
			preparedStatement1.setString(1, facture.getNumFacture());

			// execution de la requete
			preparedStatement1.executeUpdate();

			System.out.println("Facture supprimée de la base !");
		} catch (SQLException e) {
			System.out.println("cette Facture n'existe pas dans la base!");
			e.printStackTrace();
		}

	}

	/**
	 * permet de trouver une facture à partir du numero facture
	 */

	@Override
	public Facture rechercherParNumFacture(String numFacture) {
		Facture facture = null;
		try {
			// creation de la zone de requete
			String sql = "SELECT * FROM facture WHERE numFacture = ? ";
			 preparedStatement1 = conn.prepareStatement(sql);

			preparedStatement1.setString(1, numFacture);

			// execution de la requete
			ResultSet rs = preparedStatement1.executeQuery();

			// traitement du resultat de la requete
			while (rs.next()) {
				int idFactureRecup = rs.getInt("idFacture");
				String numFactureRecup = rs.getString("numFacture");
				String codeProduitRecup = rs.getString("codeProduit");
				String referenceFactureRecup = rs.getString("referenceFacture");
				int prixDeVenteRecup = rs.getInt("prixDeVente");
				int stockSortieRecup = rs.getInt("stockSortie");
				int totalFactureRecup = rs.getInt("totalFacture");

				facture = new Facture(idFactureRecup, numFactureRecup, codeProduitRecup, referenceFactureRecup,
						prixDeVenteRecup, stockSortieRecup, totalFactureRecup);

				if (facture != null) {
					System.out.println("Facture trouvée !");
				}
			}

		} catch (SQLException e) {
			System.out.println("cette facture n'existe pas !");
			e.printStackTrace();
		}
		finally {
			try {
				preparedStatement1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return facture;
	}

}
