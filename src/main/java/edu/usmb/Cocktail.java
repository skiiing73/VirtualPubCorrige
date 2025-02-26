package edu.usmb;

import java.util.ArrayList;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail extends Boisson{
	
	private static class Ingrediant{
		public String ingredient;
		public Double quantite;
		public boolean alcoolise;
		public Ingrediant(String ingredient, Double quantite, Boolean alcoolise){
			this.ingredient = ingredient;
			this.quantite = quantite;
			this.alcoolise = alcoolise;
		}

	}

	public ArrayList<Ingrediant> ingrediants;

	
	/**
	 * Creates a Cocktail with its name
	 * @param nom
	 */
	public Cocktail(String nom,Boolean alcoolise){
		super(nom);
		this.ingrediants = new ArrayList<>();
		this.alcoolise = alcoolise;
	}
	
	/**
	 * add a new element into the Cocktail.
	 * @param ingrediant
	 * @param quantite
	 */
	public void add(String ingrediant, Double quantite, Boolean ingrediants_alcoolise) {
		if (ingrediant == null) {
			throw new NullPointerException("L'ingrédient ne peut pas être null.");
		}
		if (quantite == null) {
			throw new NullPointerException("La quantité ne peut pas être null.");
		}
		if (alcoolise == null) {
			throw new NullPointerException("Le paramètre alcoolisé ne peut pas être null.");
		}

		this.ingrediants.add(new Ingrediant(ingrediant, quantite, ingrediants_alcoolise));
		if (ingrediants_alcoolise) {
			this.alcoolise = true;
		}
	}

	
	/**
	 * alcoolFree test if the Cocktail is free alcool.
	 * @return true if the Cocktail is free alcool
	 */
	public Boolean alcoolFree(){

		return !this.alcoolise;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder();
		for (Ingrediant current : this.ingrediants) {
			retour.append(current.ingredient).append(" ").append(current.quantite).append("%\t");
		}
		String results=retour.toString()+nom;
		return results;
	}


}
