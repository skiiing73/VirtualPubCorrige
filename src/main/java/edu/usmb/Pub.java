package edu.usmb;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Virtual PUB
 */
public class Pub {

	private static final Logger logger = Logger.getLogger(Pub.class.getName());

	private final Bar bar;
	private final Cave cave;

	public Pub() {
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public Bar getBar() {
		return bar;
	}

	public Cave getCave() {
		return cave;
	}

	public void approvisionnerBar(String nom) {
		this.bar.add(this.cave.take(nom));
	}

	public static void main(String[] args) {
		// Configurer le logger
		ConsoleHandler consoleHandler = new ConsoleHandler();
		logger.addHandler(consoleHandler);
		logger.setLevel(Level.INFO); // Niveau de log

		/* Création du pub */
		Pub pub = new Pub();
		String nomBiere = "Bière";
		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson whisky = new Boisson("Whisky", 40.0f);
		Boisson biere = new Boisson(nomBiere, 8.0f);

		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(whisky);
		pub.cave.add(whisky);
		pub.cave.add(biere);
		pub.cave.add(biere);
		pub.cave.add(eau);

		// Conditional logging
		if (logger.isLoggable(Level.INFO)) {
			logger.info("Cave initiale :");
			logger.info(pub.cave.toString());
		}

		// Correction : normalisation des noms des boissons
		pub.approvisionnerBar(nomBiere);
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("Eau");

		Cocktail maz = new Cocktail("Mazout", true);
		maz.add(nomBiere, 50.0, false);
		maz.add("Coca", 50.0, true);
		pub.bar.add(maz);

		Boisson cafe = new Boisson("Café");
		pub.bar.addBoissonChaude(cafe);

		// Conditional logging for pub.cave and pub.bar
		if (logger.isLoggable(Level.INFO)) {
			logger.info(pub.cave.toString());
			logger.info(pub.bar.toString());
		}

		// Conditional logging for the served drink
		if (logger.isLoggable(Level.INFO)) {
			logger.info("Boisson servie : " + pub.bar.serv("Café"));
			logger.info(pub.bar.toString());
		}
	}
}
