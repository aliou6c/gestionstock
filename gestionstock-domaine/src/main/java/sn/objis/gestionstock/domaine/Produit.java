package sn.objis.gestionstock.domaine;
import sn.objis.gestionstock.domaine.Produit;

public class Produit {
	private int idProduit;
	private String codeProduit;
	private String designationProduit;
	private int rayon;
	private String fournisseur;
	private int prix;
	private int remise;
	private int stock;
	
	public Produit() {
	}

	/**
	 * Constructeur avec 8 parametres 
	 * @param idProduit
	 * @param codeProduit
	 * @param designationProduit
	 * @param rayon
	 * @param fournisseur
	 * @param prix
	 * @param remise
	 * @param stock
	 */
	public Produit(int idProduit, String codeProduit, String designationProduit, int rayon, String fournisseur,
			int prix, int remise, int stock) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.designationProduit = designationProduit;
		this.rayon = rayon;
		this.fournisseur = fournisseur;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
	}

	/**
	 * Constructeur avec 7 parametres
	 * @param codeProduit
	 * @param designationProduit
	 * @param rayon
	 * @param fournisseur
	 * @param prix
	 * @param remise
	 * @param stock
	 */
	public Produit(String codeProduit, String designationProduit, int rayon, String fournisseur, int prix, int remise,
			int stock) {
		super();
		this.codeProduit = codeProduit;
		this.designationProduit = designationProduit;
		this.rayon = rayon;
		this.fournisseur = fournisseur;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getDesignationProduit() {
		return designationProduit;
	}

	public void setDesignationProduit(String designationProduit) {
		this.designationProduit = designationProduit;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getRemise() {
		return remise;
	}

	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", codeProduit=" + codeProduit + ", designationProduit="
				+ designationProduit + ", rayon=" + rayon + ", fournisseur=" + fournisseur + ", prix=" + prix
				+ ", remise=" + remise + ", stock=" + stock + "]";
	}
	
	
	
	
	
	
	
}
