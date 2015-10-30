import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Antworten
{
	private List<String> antworten;


	public Antworten()
	{
		antworten = new ArrayList<>();
		setDefaultActvities();
	}

	private void setDefaultActvities()
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
	// Alle Antworten aus der Liste entfernen
	{
		
		antworten.removeAll(antworten);
	}

	public String getStringlItemsInListe()
	{

		return " " + antworten.size();
	}

	public void addAntwort(String text)
	{
		aufDoppelteEinträgePrüfen(text);
		antworten.add(text);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antworten == null) ? 0 : antworten.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Antworten other = (Antworten) obj;
		if (antworten == null)
		{
			if (other.antworten != null)
				return false;
		} else if (!antworten.equals(other.antworten))
			return false;
		return true;
	}
// TODO: doppelt verhindern !
	public String aufDoppelteEinträgePrüfen(String text)
	{
		if (!antworten.contains(text))
		{
			System.out.println("ok");
			EntscheidungsKnopf.setAddedText();

			return text;
		} else
		{
			System.out.println("doppelt");
			EntscheidungsKnopf.setDeclinedText();

			return null;
		}
	}
//TODO auf "  " Leerzeichen prüfen bzw. mittels Trim abschneiden

}