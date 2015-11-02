import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Antworten
{
	private List<String> antworten;

	public Antworten()
	{
		antworten = new ArrayList<>();
		setDefaultActivities();
	}

	private void setDefaultActivities()
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

	public String getRandomAntwort()
	// Zieht eine zufällige Antowrt aus der Antworten-Liste
	{
		Random randomGenerator = new Random();
		if (antworten.isEmpty())
		{
			return "Bitte zuerst eine Aktivität eingeben!";
		} else
		{
			int index = randomGenerator.nextInt(antworten.size());
			return antworten.get(index);
		}
	}

	public void alleAntwortenLoeschen()
	{

		antworten.removeAll(antworten);
	}

	public int getItemsInListe()
	{

		return antworten.size();
	}

	public void addAntwortToList(String text)
	{
		antworten.add(text);
	}

	public boolean checkIfExistingEntry(String text)
	{
		if (!antworten.contains(text))
		{
			System.out.println("ok");

			return false;

		} else
		{
			System.out.println("doppelt");
			return true;

		}
	}
	// TODO auf "  " Leerzeichen prüfen bzw. mittels Trim abschneiden

}