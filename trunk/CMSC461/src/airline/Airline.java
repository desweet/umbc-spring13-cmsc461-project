package airline;

import java.sql.*;
//import java.util.Date;
import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Airline {
	private Connection CONN = null;
	private int CAPACITY = 100;
	
	public Airline ( ){
		try {
		// load JDBC driver for MySQL, will have to change to run on Oracle
		Class.forName("com.mysql.jdbc.Driver");
		
		// establish connection to database to be used for every method
		CONN = DriverManager.getConnection("jdbc:mysql://mysql.desweet.com/cmsc461?" + "user=mpod&password=weasel");
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
		}
	}
	
	/* @input: Flight object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	@SuppressWarnings("deprecation")
	public Boolean addFlight(Flight f){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into flights values (default, ?, ?, ?, ?, ?, ?)");
			
			//get date created, and set depart and arrival times
			//Calendar today = Calendar.getInstance();
			
			//setting the parameters
			insertStatement.setDate(1, new java.sql.Date(Calendar.YEAR, Calendar.DAY_OF_MONTH, Calendar.MONTH)); 	  // date
			insertStatement.setString(2, f.getAircraftType());														  // aircraft
			insertStatement.setString(3, f.getSource());													  		  // source
			insertStatement.setString(4, f.getDestination());														  // arrival
			insertStatement.setTimestamp(5, new Timestamp(f.getDeparture().getTime()));						  		  // depart time
			insertStatement.setTimestamp(6, new Timestamp(f.getArrival().getTime()));						  		  // arrival time
			
			//insert into database
			insertStatement.executeUpdate();
			insertStatement.close();
		} catch (Exception e){
			System.out.println("Failure: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	/* @input: Passenger object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	public Boolean addPassenger(Passenger p){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into passengers values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//setting the parameters
			insertStatement.setDouble(1, p.getSSN());										// SSN
			insertStatement.setString(2, p.getFirstName());									// first name
			insertStatement.setString(3, p.getLastName());									// last name
			insertStatement.setInt(4, p.getAge());											// age
			insertStatement.setString(5, p.getStreet());									// street
			insertStatement.setInt(6, p.getApartmentNum());									// apartment #
			insertStatement.setString(7, p.getCity());										// city
			insertStatement.setString(8, p.getState());										// state
			insertStatement.setInt(9, p.getZipcode());										// zip_code
			insertStatement.setDouble(10, p.getHomePhone());							    // home phone #
			insertStatement.setDouble(11, p.getWorkPhone());     							// work phone #
			
			//insert into database
			insertStatement.executeUpdate();
			insertStatement.close();
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	/* @input: Passenger object to add to database
	 * @output: Boolean for if adding the flight was successful
	 */
	public String makeReservation(Reservation r){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into reservations values (?, ?, ?, ?, ?, ?, ?)");
			
			//check number booked for flight
			String status = "waiting";
			int seatNum = 0;
			int numPass = countPassengers(r.getFlightNum());
			
			//calculate seat number
			if (numPass <= CAPACITY){
				status = "confirmed";
				seatNum = numPass++;	
			}
			
			//setting the parameters
			insertStatement.setInt(1,  r.getFlightNum());								// flight number
			insertStatement.setDouble(2, r.getSSN());									// SSN
			insertStatement.setString(3, status);                                    	// status
			insertStatement.setString(4, r.getSeatType());								// class
			insertStatement.setInt(5, seatNum);											// seat #
			insertStatement.setDouble(6, r.getAmountCharged());							// amount charged
			insertStatement.setInt(7,  r.getNumBags());									// num bags
			
			
			insertStatement.executeUpdate();
			insertStatement.close();
			return status;
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return null;
		}
	}
	
	
	//close connection to database
	public void close(){
		try {
			if (CONN != null){
				CONN.close();
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//given the flight number, counts the number of confirmed reservations
	public int countPassengers(int flightNum){
		int count = 0;
		try {
			PreparedStatement query = CONN.prepareStatement("SELECT count(*) FROM reservations WHERE flight_number = ? and status = \"confirmed\" or status = \"checked-in\"");
	
			query.setInt(1, flightNum);
			ResultSet result = query.executeQuery();
			result.first();
			count = result.getInt(1);
		} catch (Exception e) {
			System.out.println("Failure! " + e.getMessage());
		}
		
		return count;
	}
	
	//return array of all the current flight numbers
	public ArrayList<String> getFlightNumbers( ){
		try {
			Statement query = CONN.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM flights");
			
			ArrayList<String> flightNumbers = new ArrayList<String>();
			
			result.first();
			
			//prime loop
			flightNumbers.add(Integer.toString(result.getInt("flight_number")));
			while (result.next()){
				flightNumbers.add(Integer.toString(result.getInt("flight_number")));
			}
			
			return flightNumbers;
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return null;
		}
	}
	
	
	//-----------------------------------------------------Private Methods-----------------------------------------------------------------------
	
	
	
	
	//----------------------------------------------------End Private Methods---------------------------------------------------------------------
	
	
	
	// main for testing
	public static void main(String [ ] args){
		
//		System.out.println("initializing Airline");
		Airline a = new Airline();

		Reservation r = new Reservation(1, 123456788, "first", 75.25, 2 );

		ArrayList<String> fn = a.getFlightNumbers();
		
		for(int i = 0; i < fn.size(); i++){
			System.out.println(fn.get(i));
		}
		
//		if (a.makeReservation(r) != null){
//			System.out.println(":)");
//		} else {
//			System.out.println(":(");
//		}
//			
		//close connection to Database
		a.close();
	}
	
}
