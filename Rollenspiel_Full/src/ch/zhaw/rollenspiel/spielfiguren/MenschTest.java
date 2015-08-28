package ch.zhaw.rollenspiel.spielfiguren;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.zhaw.rollenspiel.gegenstand.*;


public class MenschTest
{
	/**
	 * Default constructor for test class MenschTest
	 */
	public MenschTest()
	{
	}

	/**
	 * Sets up the test fixture.
	 *
	 * Called before every test case method.
	 */
	@Before
	public void setUp()
	{
	}

	/**
	 * Tears down the test fixture.
	 *
	 * Called after every test case method.
	 */
	@After
	public void tearDown()
	{
	}

	@Test
	public void kampftest10000()
	{
		Mensch mensch1 = new Mensch("sda");
		Ork ork1 = new Ork("ork");
		mensch1.setLebenspunkte(10000);
		ork1.setLebenspunkte(10000);
		assertEquals(false, mensch1.kaempfeGegen(ork1));
	}

	@Test
	public void kampftest10()
	{
		Mensch mensch1 = new Mensch("sda");
		Ork ork1 = new Ork("ork");
		mensch1.setLebenspunkte(100);
		ork1.setLebenspunkte(10);
		assertEquals(true, mensch1.kaempfeGegen(ork1));
	}

	@Test
	public void gegenstandTest()
	{
		Gegenstand gegensta1 = new Gegenstand("Test", 10);
		Gegenstand gegensta2 = new Gegenstand("Test2", 10);
		
		Mensch mensch1 = new Mensch("hans");
		mensch1.setTragkraft(19.0);
		
		assertEquals(true, mensch1.nehmeGegenstand(gegensta1));
		assertEquals(false, mensch1.nehmeGegenstand(gegensta2));
	}
}

