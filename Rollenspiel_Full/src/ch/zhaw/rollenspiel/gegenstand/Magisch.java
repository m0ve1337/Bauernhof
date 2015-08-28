package ch.zhaw.rollenspiel.gegenstand;

import ch.zhaw.rollenspiel.spielfiguren.Spielfigur;

public interface Magisch {

	/**
	 * Führt den Zauber auf die Spielfigur aus.
	 */
	void zauberAnwenden(Spielfigur ziel);

	/**
	 * @return die Zauberkraft des magischen Objekt zurück.
	 */
	double getZauberkraft();

	
	
}
