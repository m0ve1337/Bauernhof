public class Tea implements Drinkable {
	private String	flavour;
	public Tea(String flavour) {
		this.flavour = flavour;
	}
	public String getFlavour() {
		return flavour + " Tea";
	}
}
