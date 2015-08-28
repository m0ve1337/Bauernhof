package ch.zhaw.rollenspiel.waffen;

public class Schwert extends Handwaffe
{
	private static final int ANGRIFFSWERT = 7;
	private static final int VERTEIDIGUNGSWERT = 4;
	
	public Schwert(double angriffswert, double verteidigungswert)
	{
		super(ANGRIFFSWERT, VERTEIDIGUNGSWERT);
	}

}
