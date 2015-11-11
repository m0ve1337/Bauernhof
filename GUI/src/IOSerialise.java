import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOSerialise {
	private String speicherort;

	public void serialise(Entscheidungen input) {

		try (FileOutputStream fos = new FileOutputStream(speicherort);

		ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(input);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Entscheidungen deserialise(Entscheidungen input) {
		try (FileInputStream fis = new FileInputStream(speicherort);
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			Entscheidungen antworten1 = (Entscheidungen) ois.readObject();
			return antworten1;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSpeicherort() {
		return speicherort;
	}

	public void setSpeicherort(String speicherort) {
		this.speicherort = speicherort;
	}

}
