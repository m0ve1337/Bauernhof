package ch.zhaw.rollenspiel.spielfiguren;

public class Mensch extends Spielfigur
{

	public Mensch(String name)
	{
		super(name);
	}

	@Override
	public int getIQ() {
		//der Mensch hat ein IQ von 98, plus die Anzahl Gegenstände, welche er mit sich rumträgt.
		int iq = 98;
		
		
		return iq + super.getAnzahlGegenstaende();
	}

	

}
