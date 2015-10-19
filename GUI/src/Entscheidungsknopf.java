import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entscheidungsknopf
{
	private List<String> antworten;
	private Random randomGenerator;

	public Entscheidungsknopf()
	{
		antworten = new ArrayList<String>();
		setDefaultAntworten();
		randomGenerator = new Random();

	}


	public void setDefaultAntworten()
	{
		antworten.add("Surfern lernen");
		antworten.add("Einen Lamborghini fahren");
		antworten.add("Bungee jumping");
		antworten.add("Wakeboarden");
		antworten.add("Snowboarden");
		antworten.add("Windsurfen lernen");
		antworten.add("Polarlichter beobachten");
		antworten.add(" Eine andere Sprache lernen");
		antworten.add("Einen Striptease hinlegen");
		antworten.add(" 2 Tage durchfeiern");
		antworten.add("Ein Tattoo stechen lassen");
		antworten.add("Die 10 besten Filme aller Zeiten sehen");
		antworten.add("2 Tage Fasten");
		antworten.add("Einen Baum mit einer Axt fällen ");
		antworten.add("Eine Nacht im Gefängnis verbringen");

	}

	public String randomAntwort()
	{
		int index = randomGenerator.nextInt(antworten.size());
		return antworten.get(index);
	}
}
