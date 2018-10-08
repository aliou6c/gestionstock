package sn.objis.gestionstock.domaine;
import sn.objis.gestionstock.domaine.Facture;

public class Facture {
	private int idFacture;
	private String numFacture;
	private String codeProduit;
	private String referenceFacture;
	private int prixDeVente;
	private int stockSortie;
	private int totalFacture;
	
	//Constructeur sans parametres
	public Facture() {
		
	}

	/**
	 * Constructeur avec 7 parametres
	 * @param idFacture
	 * @param numFacture
	 * @param codeProduit
	 * @param referenceFacture
	 * @param prixDeVente
	 * @param stockSortie
	 * @param totalFacture
	 */
	public Facture(int idFacture, String numFacture, String codeProduit, String referenceFacture, int prixDeVente,
			int stockSortie, int totalFacture) {
		super();
		this.idFacture = idFacture;
		this.numFacture = numFacture;
		this.codeProduit = codeProduit;
		this.referenceFacture = referenceFacture;
		this.prixDeVente = prixDeVente;
		this.stockSortie = stockSortie;
		this.totalFacture = totalFacture;		
		
	}

	/**
	 * Constructeur avec 6 parametres
	 * @param numFacture
	 * @param codeProduit
	 * @param referenceFacture
	 * @param prixDeVente
	 * @param stockSortie
	 * @param totalFacture
	 */
	public Facture(String numFacture, String codeProduit, String referenceFacture, int prixDeVente, int stockSortie,
			int totalFacture) {
		super();
		this.numFacture = numFacture;
		this.codeProduit = codeProduit;
		this.referenceFacture = referenceFacture;
		this.prixDeVente = prixDeVente;
		this.stockSortie = stockSortie;
		this.totalFacture = totalFacture;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getNumFacture() {
		return numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getReferenceFacture() {
		return referenceFacture;
	}

	public void setReferenceFacture(String referenceFacture) {
		this.referenceFacture = referenceFacture;
	}

	public int getPrixDeVente() {
		return prixDeVente;
	}

	public void setPrixDeVente(int prixDeVente) {
		this.prixDeVente = prixDeVente;
	}

	public int getStockSortie() {
		return stockSortie;
	}

	public void setStockSortie(int stockSortie) {
		this.stockSortie = stockSortie;
	}

	public int getTotalFacture() {
		return totalFacture;
	}

	public void setTotalFacture(int totalFacture) {
		this.totalFacture = totalFacture;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", numFacture=" + numFacture + ", codeProduit=" + codeProduit
				+ ", referenceFacture=" + referenceFacture + ", prixDeVente=" + prixDeVente + ", stockSortie="
				+ stockSortie + ", totalFacture=" + totalFacture + "]";
	}

}
