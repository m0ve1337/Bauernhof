package ch.zhaw.rollenspiel.initialise;

import ch.zhaw.rollenspiel.gegenstand.Zauberstab;
import ch.zhaw.rollenspiel.spielfiguren.Mensch;
import ch.zhaw.rollenspiel.spielfiguren.Ork;
import ch.zhaw.rollenspiel.spielfiguren.Zauberer;
import ch.zhaw.rollenspiel.waffen.Waffe;

;

public class Initialise {

	public static void main(String[] args) {
		Mensch mensch1 = new Mensch("Mensch");
		Ork ork1 = new Ork("Ork");
		Zauberer zauber1 = new Zauberer("Merlin", 12);
		Waffe schwert = new Waffe(12);

		mensch1.setWaffe(schwert);

		mensch1.kaempfeGegen(ork1);

		Zauberstab stab1 = new Zauberstab("Stab", 12);
		zauber1.nehmeGegenstand(stab1);
		zauber1.zaubern(stab1, ork1);

	}

}
