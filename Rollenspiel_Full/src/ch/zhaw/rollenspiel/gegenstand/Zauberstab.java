package ch.zhaw.rollenspiel.gegenstand;

import ch.zhaw.rollenspiel.spielfiguren.Spielfigur;

public class Zauberstab extends Gegenstand implements Magisch {
private int zauberkraft;

	public Zauberstab(String name, int gewicht) 
	{
		super(name, gewicht);
		this.zauberkraft = 7;
		
	}

	@Override
	public void zauberAnwenden(Spielfigur ziel) {
		ziel.setLebenspunkte(ziel.getLebenspunkte() + this.zauberkraft);
		
	}

	@Override
	public double getZauberkraft() {
		return this.zauberkraft;
	}
	


}
