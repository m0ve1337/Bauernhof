package ch.zhaw.abstakt;

public abstract class Person
{
	private String name;

	public Person(String name)
	{
		super();
		this.name = name;
	}


	public void printInfo()
	{
		System.out.println("Diese Person ist ein[e] "
				+ this.getClass().getSimpleName()
				+ " und heisst " + name);

	}
	
	// alternative Loesung:
public abstract String getGeschlecht();
public void printInfo2()
{
	System.out.println("Diese Person ist "
			+ getGeschlecht()
			+ " und heisst " + name);

}


}
