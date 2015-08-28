package ch.zhaw.rollenspiel.spielfiguren;

public class Ork extends Spielfigur {

	public Ork(String name) {
		super(name);
	}

	@Override
	public int getIQ() {
		// der Ork hat ein IQ von 30 + seinen Kampfwert
		int iq = 30;
		return (int) this.getKampfwert() + iq;
	}

}
