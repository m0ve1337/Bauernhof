package ch.zhaw.rollenspiel.spielfiguren;

import java.util.ArrayList;

import ch.zhaw.rollenspiel.gegenstand.Gegenstand;
import ch.zhaw.rollenspiel.gegenstand.Magisch;

public class Zauberer extends Mensch {
	private ArrayList<Gegenstand> magischeGegenstaende;
	private double magiepunkte;

	public Zauberer(String name, double magiepunkte) {
		super(name);
		this.magiepunkte = 12.4;
		magischeGegenstaende = new ArrayList<>();
	}

	public double getMagiepunkte() {
		return magiepunkte;
	}

	public void setMagiepunkte(double magiepunkte) {
		this.magiepunkte = magiepunkte;
	}

	/**
	 * Benuetzt den gegebenen magischen Gegenstand auf die Ziel-Spielfigur, aber
	 * nur wenn der magische Gegenstand im Besitze des Zauberers ist.
	 *
	 * @param magischerGegenstand
	 *            den magischen Gegenstand
	 * @param ziel
	 *            die Ziel-Spielfigur
	 */
	public void zaubern(Magisch magischerGegenstand, Spielfigur ziel) {
		if (magischeGegenstaende.contains(magischerGegenstand)) {
			magischerGegenstand.zauberAnwenden(ziel);
			System.out.println(magischerGegenstand + " wurde auf " + ziel
					+ " angewendet");
			
		} else
			System.out.println("Der Gegenstand " + magischerGegenstand
					+ " ist nicht im Inventar!");

	}

	@Override
	/**
	 * Nimmt ein Gegenstand auf, jedoch nur, wenn noch genuegend Tragkraft
	 * vorhanden ist. Wird ein Gegenstand aufgenommen, wird die Tragkraft
	 * entsprechend reduziert und <code>true</code> zurueckgegeben. Ist der
	 * Gegenstand zu schwer fuer die verbleibende Tragkraft, so wird
	 * <code>false</code> zurueckgegeben.
	 *
	 * @param gegenstand
	 *            der Gegenstand, der aufgenommen werden soll.
	 * @return <code>true</code> wenn der Gegenstand aufgenommen wurde, sonst
	 *         <code>false</code>.
	 */
	public boolean nehmeGegenstand(Gegenstand gegenstand) {
		if ((gegenstand instanceof Magisch)) {
			magischeGegenstaende.add(gegenstand);
			super.nehmeGegenstand(gegenstand);

		} else {
			super.nehmeGegenstand(gegenstand);
			


		}
		return false;

	}

	@Override
	public int getIQ() {
		// – beim Zauberer kommt die Hälfte seiner Zauberkraft dem IQ des Menschen hinzu.
		return (int) (super.getIQ() + (magiepunkte / 2));
	}
}
