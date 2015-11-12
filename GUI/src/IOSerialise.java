import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class IOSerialise {
	private String	dateiPfad;

	public void serialise(AktivitaetenListe input) {

		try (FileOutputStream fos = new FileOutputStream(dateiPfad);

		ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(input);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param input
	 *            eine serialisierte AktivitätenListe (z.B über das GUI
	 *            ausgewählt)
	 * @return eine deserialisierte AktivitätenListe
	 */
	public AktivitaetenListe deserialise(AktivitaetenListe input) {

		try (FileInputStream fis = new FileInputStream(dateiPfad); ObjectInputStream ois = new ObjectInputStream(fis)) {

			AktivitaetenListe liste = (AktivitaetenListe) ois.readObject();
			return liste;

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
