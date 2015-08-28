package ch.zhaw.rollenspiel.waffen;

public class Handwaffe extends Waffe {

	private double verteidigungswert;


	public Handwaffe(double angriffswert, double verteidigungswert)
	{
		super(angriffswert);
		this.verteidigungswert = verteidigungswert;
	}

	public double getVerteidigungswert()
	{
		return verteidigungswert;
	}

	public void setVerteidigungswert(double verteidigungswert)
	{
		this.verteidigungswert = verteidigungswert;
	}

	@Override
	/**
	 * Gibt den Kampfwert zuruek.
	 * 
	 * @return den Kampfwert.
	 */
	public int getKampfwert()
	{
		return (int) (super.getAngriffswert() + (getVerteidigungswert() / 2));


	}
}
