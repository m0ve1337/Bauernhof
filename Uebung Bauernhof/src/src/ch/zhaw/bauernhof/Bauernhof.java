package src.ch.zhaw.bauernhof;

import java.util.HashSet;
import java.util.Set;

public class Bauernhof
{
	private Set<Tier> stall;

	public Bauernhof()
	{
		this.stall = new HashSet<>();
	}

	public void addTier(Tier tier)
	{
		stall.add(tier);
	}

	public void gibLaut()
	{
		for (Tier t : stall)
		{
			t.gibLaut();
		}
	}
}
