package edu.usmb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pierre Le Fameux
 */
public class Cave {
	private final List<Boisson> rayons;

	public Cave() {
		this.rayons = new ArrayList<>();
	}

	public void add(Boisson b) {
		if (b != null) {
			this.rayons.add(b);
		}
	}

	public Boisson take(String nom) {
		if (nom == null || nom.isEmpty()) {
			return null;
		}

		Iterator<Boisson> iterator = this.rayons.iterator();
		while (iterator.hasNext()) {
			Boisson boisson = iterator.next();
			if (boisson.getNom().equalsIgnoreCase(nom)) {
				iterator.remove();
				return boisson;
			}
		}
		return null; // Retourne null si aucune boisson correspondante n'a été trouvée
	}

	@Override
	public String toString() {
		StringBuilder retour = new StringBuilder("Cave :\n");
		for (Boisson boisson : rayons) {
			retour.append("\t").append(boisson).append("\n");
		}
		return retour.toString();
	}
}
