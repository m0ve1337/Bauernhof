package Buch_Kapitel11;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class MusikTest1 {

	public void spielen() {
		try {
			@SuppressWarnings("unused")
			Sequencer sequencer = MidiSystem.getSequencer();

			System.out.println("Wir haben einen Sequenzer :) ");
		} catch (MidiUnavailableException ex) {
			System.out.println("nix Sequencer!");
		}
	} // spielen schliessen

	public static void main(String[] args) {
		MusikTest1 mt = new MusikTest1();
		mt.spielen();

	}
}
