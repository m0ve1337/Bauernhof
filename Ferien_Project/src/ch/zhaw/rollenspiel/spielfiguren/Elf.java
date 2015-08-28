package ch.zhaw.rollenspiel.spielfiguren;

public class Elf extends Spielfigur
{
	private int zauberwert;

	public Elf(String name, double lebenspunkte, int tragkraft, int zauberwert)
	{
		super(name, lebenspunkte, tragkraft);
		zauberwert = 10;
	}

	public int getZauberwert()
	{
		return zauberwert;
	}

	public void setZauberwert(int zauberwert)
	{
		this.zauberwert = zauberwert;
	}

	@Override
	public double getKampfwert()
	{
		return super.getKampfwert() + (zauberwert / 2);

	}
}
