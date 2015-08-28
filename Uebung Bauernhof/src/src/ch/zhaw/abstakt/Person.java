package src.ch.zhaw.abstakt;

public abstract class Person
{

	public Person(String name)
	{
		super();
		this.name = name;
	}

	String name;

	void printInfo()
	{
		System.out.println("Diese Person ist ein[e] "
				+ this.getClass().getSimpleName()
				+ " und heisst " + name);

	}




}
