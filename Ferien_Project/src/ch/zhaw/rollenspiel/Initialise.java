package ch.zhaw.rollenspiel;

import ch.zhaw.rollenspiel.spielfiguren.Elf;
import ch.zhaw.rollenspiel.spielfiguren.Mensch;





public class Initialise {

	public static void main(String[] args) {
		Mensch mensch1 = new Mensch("Menschli",15.0,10);
	Mensch mensch2= new Mensch("name",200.00,10);

		Elf elf1 = new Elf("Elfi", 15.0, 10, 0);


		mensch1.kaempfeGegen(elf1);
		mensch1.setLebenspunkte(200);
		mensch2.kaempfeGegen(mensch1)
;		

		

	}

}
