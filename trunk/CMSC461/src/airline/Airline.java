package airline;

import java.sql.*;
import java.util.Date;

public class Airline {
	private Connection CONN = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultset = null;
	
	public Airline ( ){
		try {
		// load JDBC driver for MySQL, will have to change to run on Oracle
		Class.forName("com.mysql.jdbc.Driver");
		
		// establish connection to database to be used for every method
		CONN = DriverManager.getConnection("jdbc:mysql://mysql.desweet.com/cmsc461?" + "user=mpod&password=weasel");
		} catch (Exception e) {
			System.out.println("Failure!: " + e.getMessage());
		}
	}
	
	/* @input: Flight object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	@SuppressWarnings("deprecation")
	public Boolean addFlight(){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into flights values (default, ?, ?, ?, ?, ?, ?)");
			
			//get date created, and set depart and arrival times
			Date today = new Date(System.currentTimeMillis());
			Date depart = new Date(113, 4, 30, 13, 30 );
			Date arrival = new Date(113, 5, 1, 13, 30 );
			
			//setting the parameters
			insertStatement.setDate(1, new java.sql.Date(today.getYear(), today.getDay(), today.getMonth())); // date
			insertStatement.setString(2, "Boeing 737");														  // aircraft
			insertStatement.setString(3, "Baltimore, MD");													  // source
			insertStatement.setString(4, "Seatle, WA");														  // arrival
			insertStatement.setTimestamp(5, new Timestamp(depart.getTime()));								  // depart time
			insertStatement.setTimestamp(6, new Timestamp(arrival.getTime()));								  // arrival time
			
			//insert into database
			insertStatement.executeUpdate();
			insertStatement.close();
		} catch (Exception e){
			System.out.println("Failure!: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	/* @input: Passenger object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	public Boolean addPassenger(){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into passengers values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//setting the parameters
			insertStatement.setDouble(1, 123456788);									// SSN
			insertStatement.setString(2, "Little");									// first name
			insertStatement.setString(3, "Fucker");									// last name
			insertStatement.setInt(4, 21);											// age
			insertStatement.setString(5, "1234 Road to No Where");					// street
			insertStatement.setInt(6, 2);									        // apartment #
			insertStatement.setString(7, "Baltimore");								// city
			insertStatement.setString(8, "MD");										// state
			insertStatement.setInt(9, 12345);										// zip_code
			insertStatement.setDouble(10, 1555555555);							    // home phone #
			insertStatement.setDouble(11, 1234567890);     							// work phone #
			
			//insert into database
			insertStatement.executeUpdate();
			insertStatement.close();
		} catch (Exception e) {
			System.out.println("Failure!: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/* @input: Passenger object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	public Boolean makeReservation( ){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into reservations values (deafult, ?, ?, default, ?, ?, ?, ?)");
			
			//check number booked for flight
			
			//setting the parameters
			insertStatement.setInt(1,  1);											// flight number
			insertStatement.setInt(2, 123456789);									// SSN
			insertStatement.setString(3, "first");									// class
			insertStatement.setInt(4, 3);											// seat #
			insertStatement.setDouble(5, 60.43);									// amount charged
			insertStatement.setInt(6, 3);								// num bags
			
			insertStatement.executeUpdate();
			insertStatement.close();
		} catch (Exception e) {
			
		}
		
		return true;
	}
	
	
	
	
	public void close(){
		try {
			if (CONN != null){
				CONN.close();
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	// main for testing
	public static void main(String [ ] args){
System.out.println("TEST");
		
		System.out.println("initializing Airline");
		Airline a = new Airline();
		System.out.println("Calling addFlight!");
		if (a.addFlight()){
			System.out.println(":)");
		} else {
			System.out.println(":(");
		}
		if (a.addPassenger()){
			System.out.println(":)");
		} else {
			System.out.println(":(");
		}
		if (a.makeReservation()){
			System.out.println(":)");
		} else {
			System.out.println(":(");
		}
		
		//close connection to Database
		a.close();
	}
	
}
