public class Sirup implements Drinkable {
	private String	flavour;
	public Sirup(String flavour) {
		this.flavour = flavour;
	}
	public String getFlavour() {
		return flavour + " Sirup";
	}
}