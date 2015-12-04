
public class start_tea {
	
	public static void main(String[] args) {
		
		Tea t = new Tea("Darjeeling"); 
		Cup<Tea> c = new Cup(t); 
		
		System.out.println(c);
		
		Sirup s = new Sirup("Honig");
		Cup<Sirup> d = new Cup(s); 
		System.out.println(d);

		
	}

	
	
}
