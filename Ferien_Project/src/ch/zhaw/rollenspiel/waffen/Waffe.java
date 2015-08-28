package ch.zhaw.rollenspiel.waffen;

public class Waffe
{
	private int angriffswert;

	public Waffe(int angriffswert)
	{
		this.angriffswert = angriffswert;

	}

	public int getAngriffswert()
	{
		return angriffswert;
	}

	public void setAngriffswert(int angriffswert)
	{
		this.angriffswert = angriffswert;
	}

	/**
	 * Gibt den Kampfwert zuruek.
	 * 
	 * @return den Kampfwert.
	 */

	public int getKampfwert()
	{
		return angriffswert;
	}



}
