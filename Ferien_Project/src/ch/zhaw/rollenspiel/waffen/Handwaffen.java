package ch.zhaw.rollenspiel.waffen;

public class Handwaffen extends Waffe
{
	private int verteidigungswert;

	public Handwaffen(int angriffswert, int verteidigungswert)
	{
		super(angriffswert);
	}

	public int getVerteidigungswert()
	{
		return verteidigungswert;
	}

	public void setVerteidigungswert(int verteidigungswert)
	{
		this.verteidigungswert = verteidigungswert;
	}

	@Override
	/**
	 * Gibt den Kampfwert zuruek.
	 * @return den Kampfwert.
	 */
	public int getKampfwert()
	{
		return super.getAngriffswert() + (verteidigungswert / 2);

	}

}
