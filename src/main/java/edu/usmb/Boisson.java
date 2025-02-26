package edu.usmb;


/**
 * @author Pierre Le Fameux
 *
 */
public class Boisson {
	protected String nom;
	protected Boolean alcoolise;
	private Float degre;
	private Float volume; // volume de la bouteille, cennette, fut ...
	private Float prix;
	
	/**
	 * @param nom
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
	}

	/**
	 * @param nom
	 * @param degre
	 */
	public Boisson(String nom, Float degre){
		this.nom = nom;
		this.degre = degre;
        this.alcoolise = degre > 0.0;
	}
	public String getNom(){
		return this.nom;
	}

	public Boolean getAlcoolise() {
		return alcoolise;
	}

	public Float getDegre() {
		return degre;
	}

	public Float getVolume() {
		return volume;
	}

	public Float getPrix() {
		return prix;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String retour = this.nom;
		if(Boolean.TRUE.equals(this.alcoolise)){
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		}else{
			return retour;
		}
	}
}
