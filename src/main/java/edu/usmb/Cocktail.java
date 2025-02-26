package edu.usmb;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Cocktail extends Boisson{

	private static class Ingrediant{
		private final String ingredient;
		private final Double quantite;

        public Ingrediant(String ingredient, Double quantite){
			this.ingredient = ingredient;
			this.quantite = quantite;
        }

	}

	private final List<Ingrediant> ingrediants;

	
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
	public void add(String ingrediant, Double quantite, Boolean ingrediantsAlcoolise) {
		if (ingrediant == null) {
			throw new NullPointerException("L'ingrédient ne peut pas être null.");
		}
		if (quantite == null) {
			throw new NullPointerException("La quantité ne peut pas être null.");
		}
		if (getAlcoolise() == null) {
			throw new NullPointerException("Le paramètre alcoolisé ne peut pas être null.");
		}

		this.ingrediants.add(new Ingrediant(ingrediant, quantite));
		if (Boolean.TRUE.equals(ingrediantsAlcoolise)) {
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
        return retour+getNom();
	}


}
