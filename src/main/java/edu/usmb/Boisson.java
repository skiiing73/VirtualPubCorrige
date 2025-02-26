package edu.usmb;


/**
 * @author Pierre Le Fameux
 *
 */
public class Boisson {
	public String nom;
	public Boolean alcoolise;
	public Float degre;
	public Float volume; // volume de la bouteille, cennette, fut ...
	public Float prix;
	
	/**
	 * @param nom
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = false;
	}
	public String getNom(){
		return this.nom;
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
