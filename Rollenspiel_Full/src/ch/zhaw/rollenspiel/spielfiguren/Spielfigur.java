package ch.zhaw.rollenspiel.spielfiguren;


import java.util.ArrayList;
import java.util.Random;

import ch.zhaw.rollenspiel.gegenstand.Gegenstand;
import ch.zhaw.rollenspiel.waffen.Keule;
import ch.zhaw.rollenspiel.waffen.Waffe;

public abstract class Spielfigur
{

	@Override
	public String toString() {
		return "Spielfigur " + getName() ;
	}

	private String name;
	private double lebenspunkte;
	private double tragkraft;
	private Waffe waffe;
	private ArrayList<Gegenstand> gegenstaende;

	public Spielfigur(String name)
	{
		this.setName(name);
		waffe = new Keule();
		lebenspunkte = 100;
		this.tragkraft = 13;
		gegenstaende = new ArrayList<>();

	}

	public Waffe getWaffe()
	{
		return waffe;
	}

	public void setWaffe(Waffe waffe)
	{
		this.waffe = waffe;
	}

	/**
	 * Gibt den Kampfwert der aktuellen Waffe zurueck. Der Kampfwert der Waffe
	 * wird mit einer Random-Nr. zwischen 0.9 und 1.1 multipliziert.
	 *
	 * @return der Kampfwert
	 */
	public double getKampfwert()
	// Falls Kampfwert nicht jede Runde neu
	// berechnet werden soll: Random-Zahl
	// einmalig als Instanzvariable generieren
	{
		Random r = new Random();
		double kampfwert = (0.9 + (0.2) * r.nextDouble())
				* this.waffe.getKampfwert();

		return kampfwert;
	}

	public void waffeAufheben(Waffe waffe)
	{
		this.waffe = waffe;

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
	public boolean nehmeGegenstand(Gegenstand gegenstand)
	{
		if (gegenstand.getGewicht() > getTragkraft())
		{ 
			return false;
		}
		else
		{
			this.setTragkraft(getTragkraft() - gegenstand.getGewicht());
		gegenstaende.add(gegenstand);	
		return true;
		}

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
	public boolean kaempfeGegen(Spielfigur gegner)
	{
		int runde = 1;
		System.out.println("Kampf: " + this.getName() + "Kampfwert: "
				+ this.getKampfwert() + " leben: " + this.getLebenspunkte()
				+ "\nvs:  \n" + gegner.getName() + " Kampfwert: "
				+ gegner.getKampfwert() + " leben: " + gegner.getLebenspunkte()
				+ "\n");

		while (runde < 20 && this.getLebenspunkte() > 0
				&& gegner.getLebenspunkte() > 0)
		{

			this.setLebenspunkte(this.getLebenspunkte() - gegner.getKampfwert());
			gegner.setLebenspunkte(gegner.getLebenspunkte()
					- this.getKampfwert());
			runde++;
			System.out.println("Lebenspunkte  " + this.getName() + " "
					+ this.getLebenspunkte() + " Lebenspunkte "
					+ gegner.getName() + " " + gegner.getLebenspunkte()
					+ " in Runde  " + runde);

		}
		if (runde >= 20)
		{
			System.out.println("unentschieden");
			return false;
		}

		else if (this.getLebenspunkte() > gegner.getLebenspunkte()
				&& runde < 20)
		{
			System.out.println("\nwohooo, " + this.getName()
					+ " hat den Kampf gewonnen!");
			return true;

		}

		else
		{
			System.out.println("\narrrgh, " + gegner.getName()
					+ " hat dich besiegt!");
			return false;
		}

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getLebenspunkte()
	{
		return lebenspunkte;
	}

	public void setLebenspunkte(double lebenspunkte)
	{
		this.lebenspunkte = lebenspunkte;
	}

	public double getTragkraft()
	{
		return tragkraft;
	}

	public void setTragkraft(double tragkraft)
	{
		this.tragkraft = tragkraft;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gegenstaende == null) ? 0 : gegenstaende.hashCode());
		return result;
	}

	abstract public int getIQ();
	
	

	public int getAnzahlGegenstaende() {
		return gegenstaende.size();
	}



}
