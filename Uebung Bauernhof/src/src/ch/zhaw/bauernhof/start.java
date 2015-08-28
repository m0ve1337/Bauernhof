package src.ch.zhaw.bauernhof;

public class start
{
	public static void main(String[] args)
	{

		Bauernhof hof = new Bauernhof();

		Hund hund = new Hund();
		Katze katze = new Katze();
		Kuh kuh = new Kuh();
		hof.addTier(hund);

		hof.addTier(kuh);
		hof.addTier(katze);
		hof.gibLaut();

	}
}
