package airline;

public class GUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TEST");
		
		System.out.println("initializing Airline");
		Airline a = new Airline();
		System.out.println("Calling addFlight!");
		if (a.addFlight()){
			System.out.println(":)");
		} else {
			System.out.println(":(");
		}
		
		//close connection to Database
		a.close();
		

	}

}