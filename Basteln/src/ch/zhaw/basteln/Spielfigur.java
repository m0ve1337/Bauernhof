package ch.zhaw.basteln;

public abstract class Spielfigur
{
	private int leben;
	private int staerke;
	private int defense;

	public Spielfigur()
	{


	}

	public abstract void kaempfe(Spielfigur gegner);

	public int getLeben()
	{
		return leben;
	}

	public void setLeben(int leben)
	{
		this.leben = leben;
	}

	public int getStaerke()
	{
		return staerke;
	}

	public void setStaerke(int staerke)
	{
		this.staerke = staerke;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

}

