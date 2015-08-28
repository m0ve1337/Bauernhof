package src.ch.zhaw.abstakt;

import java.util.ArrayList;

public class Register
{

	ArrayList<Person> liste = new ArrayList<>();

	public void ausgeben()
	{
		for (Person p : liste)
			p.printInfo();
	}

	public void addPerson(Person person)
	{
		liste.add(person);
	}

	public static void main(String[] args)
	{
		Register register1 = new Register();

		Frau frau1 = new Frau("Hanna");
		Mann mann1 = new Mann("Rolf");
		register1.addPerson(frau1);
		register1.addPerson(mann1);
		register1.ausgeben();

	}

}
