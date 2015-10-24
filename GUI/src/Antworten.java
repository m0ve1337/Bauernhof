import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Antworten
{
	public List<String> antworten;
	private Random randomGenerator;

	public Antworten()
	{
		antworten = new ArrayList<>();
		setDefaultAntworten();
	}

	private void setDefaultAntworten()
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

	public String setRandomAntwort()
	// Zieht eine zufällige Antowrt aus der Antworten-Liste
	{
		randomGenerator = new Random();
		if (antworten.isEmpty()){
			return "Bitte zuerst eine Antwort eingeben!";
		}
		else{
		int index = randomGenerator.nextInt(antworten.size());
		return antworten.get(index);
		}
	}

	public void alleAntwortenLoeschen()
	{
		antworten.removeAll(antworten);
	}
}