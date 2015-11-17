package refactored;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class IOSerialise {
	private String dateiPfad;

	public DisplayMessage serialise(List<String> inputListe, String pfad) {
		DisplayMessage feedbackIO = new DisplayMessage();

		if (!pfad.endsWith(".ents")) {
			dateiPfad += "." + pfad + ".ents";
		}
		else {
			dateiPfad = pfad.substring(0, pfad.length() - 5);
			dateiPfad += "." + ".ents";

		}

		setDirectory(dateiPfad);

		try (FileOutputStream fos = new FileOutputStream(dateiPfad);

		ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(inputListe);
			feedbackIO.setMessage("Liste " + pfad + " gespeichert!");
			return feedbackIO;

		} catch (IOException e) {
			e.printStackTrace();
			feedbackIO.setMessage("Fehler beim Speichern!");
			
		}
		return feedbackIO;

	}

	/**
	 * @param inputListe
	 *            eine serialisierte AktivitätenListe (z.B über das GUI
	 *            ausgewählt)
	 * @return eine deserialisierte AktivitätenListe
	 */
	public AktivitaetenListe deserialise(AktivitaetenListe inputListe) {

		try (FileInputStream fis = new FileInputStream(dateiPfad);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			AktivitaetenListe outputListe = (AktivitaetenListe) ois
					.readObject();
			return outputListe;
			//TODO direkt die ArrayListe zurückgeben mit .getListe

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getDirectory() {
		return dateiPfad;
	}

	public void setDirectory(String pfad) {
		this.dateiPfad = pfad;
	}

}
