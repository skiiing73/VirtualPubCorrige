package edu.usmb;

/**
 * Virtual PUB
 */
public class Pub {

	public Bar bar;
	public Cave cave;

	public Pub() {
		this.bar = new Bar();
		this.cave = new Cave();
	}

	public void approvisionnerBar(String nom) {
		this.bar.add(this.cave.take(nom));
	}

	public static void main(String[] args) {
		/* Création du pub */
		Pub pub = new Pub();
		String nom_biere="Bière";
		Boisson coca = new Boisson("Coca");
		Boisson eau = new Boisson("Eau");
		Boisson whisky = new Boisson("Whisky", 40.0f);
		Boisson biere = new Boisson(nom_biere, 8.0f);

		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(coca);
		pub.cave.add(whisky);
		pub.cave.add(whisky);
		pub.cave.add(biere);
		pub.cave.add(biere);
		pub.cave.add(eau);

		System.out.println("Cave initiale :");
		System.out.println(pub.cave);

		// Correction : normalisation des noms des boissons

		pub.approvisionnerBar(nom_biere);
		pub.approvisionnerBar("Whisky");
		pub.approvisionnerBar("Coca");
		pub.approvisionnerBar("Eau");

		Cocktail maz = new Cocktail("Mazout",true);
		maz.add(nom_biere, 50.0,false);
		maz.add("Coca", 50.0,true);
		pub.bar.add(maz);

		Boisson cafe = new Boisson("Café");
		pub.bar.addBoissonChaude(cafe);


		System.out.println(pub.cave);
		System.out.println(pub.bar);

		System.out.println("Boisson servie : " + pub.bar.serv("Café"));
		System.out.println(pub.bar);
	}
}
