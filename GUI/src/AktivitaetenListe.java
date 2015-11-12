import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AktivitaetenListe implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> antworten;
	private DisplayMessage entscheidungsButtonMessage;


	public AktivitaetenListe() {
		antworten = new ArrayList<>();
		entscheidungsButtonMessage = new DisplayMessage();
		setDefaultActivities();
	}

	private void setDefaultActivities() {
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
	// Zieht eine zufällige Antwort aus der Antworten-Liste
	{
		Random randomGenerator = new Random();
		if (antworten.isEmpty()) {
			return "Bitte zuerst eine Aktivität eingeben!";
		} else {
			int index = randomGenerator.nextInt(antworten.size());
			return antworten.get(index);
		}
	}

	public DisplayMessage alleAntwortenLoeschen() {
		antworten.removeAll(antworten);
		entscheidungsButtonMessage.setMessage("Einträge gelöscht!");
		return entscheidungsButtonMessage;

	}

	public void listeLaden(AktivitaetenListe eingabeliste) {

		this.antworten = eingabeliste.getAntwortenListe();

	}

	public int getItemsInListe() {
		return antworten.size();
	}

	public DisplayMessage addAntwortToList(String input) {

		String inputT = input.trim();

		if (inputT.isEmpty()) {
			entscheidungsButtonMessage
					.setMessage("Bitte keine leeren Eingaben");
		}

		else if (checkIfExistingEntry(inputT)) {
			entscheidungsButtonMessage.setMessage("Eintrag bereits vorhanden!");
		} else {
			antworten.add(inputT);
			entscheidungsButtonMessage.setMessage("Eintrag hinzugefügt!");
		}

		return entscheidungsButtonMessage;
	}

	public List<String> getAntwortenListe() {
		return antworten;
	}

	public void setAntwortenListe(List<String> antwortenListe) {
		this.antworten = antwortenListe;
	}

	public boolean checkIfExistingEntry(String text) {
		if (!antworten.contains(text)) {
			System.out.println("ok");

			return false;

		} else {
			System.out.println("doppelt");
			return true;

		}
	}

}