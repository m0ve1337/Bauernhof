package ch.zhaw.rollenspiel.spielfiguren;

import java.util.ArrayList;
import java.util.Random;

import ch.zhaw.rollenspiel.gegenstaende.Gegenstand;
import ch.zhaw.rollenspiel.waffen.Keule;
import ch.zhaw.rollenspiel.waffen.Waffe;

public class Spielfigur {

	private double lebenspunkte;
	private String name;
	private int tragkraft;
	private Waffe waffe;
	private ArrayList<Gegenstand> gegenstaende;

	public Spielfigur(String name, double lebenspunkte, int tragkraft) {
		this.waffe = new Keule();
		this.name = name;
		this.lebenspunkte = lebenspunkte;
		this.tragkraft = tragkraft;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLebenspunkte() {
		return lebenspunkte;
	}

	public void setLebenspunkte(double lebenspunkte) {
		this.lebenspunkte = lebenspunkte;
	}

	public int getTragkraft() {
		return tragkraft;
	}

	public void setTragkraft(int tragkraft) {
		this.tragkraft = tragkraft;
	}

	public Waffe getWaffe() {
		return waffe;
	}

	public void setWaffe(Waffe waffe) {
		this.waffe = waffe;
	}

	/**
	 * Gibt den Kampfwert der aktuellen Waffe zurueck. Der Kampfwert der Waffe
	 * wird mit einer Random-Nr. zwischen 0.9 und 1.1 multipliziert.
	 *
	 * @return der Kampfwert
	 */
	public double getKampfwert() {

		Random r = new Random();
		double kampfwert = (0.9 + (0.2) * r.nextDouble())
				* this.waffe.getKampfwert();

		return kampfwert;

	}

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

		if (gegenstand.getGewicht() < this.getTragkraft()) {
			gegenstaende.add(gegenstand);
			this.setTragkraft(getTragkraft() - gegenstand.getGewicht());

			return true;
		}

		return false;

	}

	/**
	 * Laesst diese Spielfigur gegen eine andere Spielfigur kaempfen.
	 *
	 * Gekaempft wird in Runden. Es wird solange gekaempft, bis eine oder beide
	 * Spielfiguren keine Lebenspunkte mehr haben. Steht nach 20 Runden noch
	 * kein Sieger fest, wird der Kampf abgebrochen.
	 *
	 * Bei jeder Runde wird der Kampfwert der einen Spielfigur den Lebenspunkten
	 * des Gegners abgezogen und umgekehrt.
	 *
	 * Diejenige Spielfigur mit den meisten verbliebenen Lebenspunkten gewinnt.
	 *
	 * @param gegner
	 *            die andere Spielfigur
	 * @return <code>true</code>, falls der Kampf gewonnen wird, sonst
	 *         <code>false</code>.
	 */

	public boolean kaempfeGegen(Spielfigur gegner) {

		for (int i = 1; i <= 20; i++) {

			if (this.getLebenspunkte() <= 0 || gegner.getLebenspunkte() <= 0) {
				if (this.getLebenspunkte() < gegner.getLebenspunkte()) {
					System.out.println("einer der Spieler ist tot: "
							+ this.getName());
					return false;

				} else {
					System.out.println("einer der Spieler ist tot: "
							+ gegner.getName());
					return true;
				}

				
			} else {

				this.setLebenspunkte(this.getLebenspunkte()
						- gegner.getKampfwert());
				gegner.setLebenspunkte(gegner.getLebenspunkte()
						- this.getKampfwert());
				System.out.println("Lebenspunkte  " + this.getName() + " "
						+ this.getLebenspunkte() + " Lebenspunkte "
						+ gegner.getName() + " " + gegner.getLebenspunkte()
						+ " in Runde  " + i);
			}
		}
		return false;
	}

}
