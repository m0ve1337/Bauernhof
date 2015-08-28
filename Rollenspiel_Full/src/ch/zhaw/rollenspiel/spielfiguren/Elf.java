package ch.zhaw.rollenspiel.spielfiguren;





public class Elf extends Spielfigur
{
	private double zauberwert;


	
	public Elf(String name, double zauberwert)
	{
		super(name);
		this.zauberwert = zauberwert;


	}



	public double getZauberwert()
	{
		return zauberwert;
	}

	public void setZauberwert(double zauberwert)
	{
		this.zauberwert = zauberwert;
	}
@Override
	/**
	 * Gibt den Kampfwert der aktuellen Waffe zurueck. Der Kampfwert der Waffe
	 * wird mit einer Random-Nr. zwischen 0.9 und 1.1 multipliziert.
	 *
	 * @return der Kampfwert
	 */
	public double getKampfwert()
	{
		return super.getKampfwert() + (zauberwert / 2); // direkt return


	}



@Override
public int getIQ() {
	int iq = 130;
	// – Der Elf hat ein IQ von 130 + die Länge seines Namens.
	return iq + super.getName().length();
}
}
