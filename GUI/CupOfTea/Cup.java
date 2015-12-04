public class Cup<T extends Drinkable> {  //nur T welche Trinbar sind
	private T	getraenk;
	public Cup(T getraenk) {
		this.getraenk = getraenk;
	}
	public T getContent() {
		return getraenk;
	}
	@Override
	public String toString() {
		return "Cup contains: " + getraenk.getFlavour();
	}
}