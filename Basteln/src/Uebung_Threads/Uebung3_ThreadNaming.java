package Uebung_Threads;

public class Uebung3_ThreadNaming {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Uebung3_MyThread());
		Thread t2 = new Thread(new Uebung3_MyThread());
		t1.setName("Eins");
		t2.setName("Zwei");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread().getName());
	}
}