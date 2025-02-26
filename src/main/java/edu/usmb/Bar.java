package edu.usmb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pierre Le Fameux
 */
public class Bar {
	private final List<Boisson> boissonChaude;
	private final List<Boisson> boissonFroide;
	private final List<Boisson> boissonAlcoolisee;
	private final List<Cocktail> cocktailSansAlcool;
	private final List<Cocktail> cocktailAvecAlcool;


	public List<Boisson> getBoissonFroide() {
		return boissonFroide;
	}

	public List<Boisson> getBoissonChaude() {
		return boissonChaude;
	}

	public List<Cocktail> getCocktailSansAlcool() {
		return cocktailSansAlcool;
	}

	public List<Cocktail> getCocktailAvecAlcool() {
		return cocktailAvecAlcool;
	}

	public List<Boisson> getBoissonAlcoolisee() {
		return boissonAlcoolisee;
	}

	

	public Bar() {
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcool = new ArrayList<>();
		this.cocktailSansAlcool = new ArrayList<>();
	}

	public void add(Boisson boisson) {
		if (boisson == null) return;
		if (Boolean.TRUE.equals(boisson.alcoolise)) {
			this.boissonAlcoolisee.add(boisson);
		} else {
			this.boissonFroide.add(boisson);
		}
	}

	public void add(Cocktail cocktail) {
		if (cocktail == null) return;
		if (Boolean.TRUE.equals(cocktail.alcoolFree())) {
			this.cocktailSansAlcool.add(cocktail);

		} else {
			this.cocktailAvecAlcool.add(cocktail);
		}
	}

	public void addBoissonChaude(Boisson boisson) {
		this.boissonChaude.add(boisson);
	}

	public Object serv(String command) {
		if (command == null || command.isEmpty()) return null;

		Object result = removeIfExists(boissonFroide, command);
		if (result == null) result = removeIfExists(boissonAlcoolisee, command);
		if (result == null) result = removeIfExists(boissonChaude, command);
		if (result == null) result = removeIfExists(cocktailSansAlcool, command);
		if (result == null) result = removeIfExists(cocktailAvecAlcool, command);

		return result;
	}

	private <T extends Boisson> T removeIfExists(List<T> list, String name) {
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			T item = iterator.next();
			if (item.nom.equalsIgnoreCase(name)) {
				iterator.remove();
				return item;
			}
		}
		return null;
	}

	@Override
	public String toString() {
        return "Bar :\n" + "\t Sans alcool\n" + formatList(boissonFroide) +
                "\t Avec alcool\n" + formatList(boissonAlcoolisee) +
                "\t Cocktail sans alcool\n" + formatList(cocktailSansAlcool) +
                "\t Cocktail avec alcool\n" + formatList(cocktailAvecAlcool) +
                "\t Boissons chaudes\n" + formatList(boissonChaude);
	}

	private <T> String formatList(List<T> list) {
		StringBuilder sb = new StringBuilder();
		for (T item : list) {
			sb.append("\t\t").append(item).append("\n");
		}
		return sb.toString();
	}
}
