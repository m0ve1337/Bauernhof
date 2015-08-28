package ch.zhaw.rollenspiel.waffen;

public class Waffe {

	private double angriffswert;

	public Waffe(double angriffswert)
	{
		this.angriffswert = angriffswert;
	}

	public double getAngriffswert()
	{
		return angriffswert;
	}

	public void setAngriffswert(double angriffswert)
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

		return (int) getAngriffswert(); // toDo: runden vor casten

	}

}
