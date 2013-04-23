package airline;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.Date;
//import java.util.Calendar;
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
	
	/*******************************************************************************************************************
	 * @input: Flight object to add to database
	 * @output: Boolean for if adding the flight was successful
	 ******************************************************************************************************************/
	public Boolean scheduleFlight(Flight f, ArrayList<Stop> stops){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into flights values (?, ?, ?, ?, ?, ?, ?)");
			
			//setting the parameters
			insertStatement.setInt(1, f.getFlightNumber());
			insertStatement.setDate(2, new java.sql.Date(System.currentTimeMillis())); 	  	  // date
			insertStatement.setString(3, f.getAircraftType());														  // aircraft
			insertStatement.setString(4, f.getSource());													  		  // source
			insertStatement.setString(5, f.getDestination());														  // arrival
			insertStatement.setTimestamp(6, new Timestamp(f.getDeparture().getTime()));						  		  // depart time
			insertStatement.setTimestamp(7, new Timestamp(f.getArrival().getTime()));						  		  // arrival time
			
			//insert flight info into database
			insertStatement.executeUpdate();
			insertStatement.close();
			
			//if there are stops
			if (stops.size() != 0){
				//add stops
			}
		} catch (Exception e){
			System.out.println("Failure: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	/*******************************************************************************************************************
	 * @input: Passenger object to add to database
	 * @output: Boolean for if adding the flight was successful
	 *******************************************************************************************************************/
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
	
	/********************************************************************************************************************
	 * @input: Passenger object to add to database
	 * @output: String ("confirmed" || "waiting") or null for error  
	 *******************************************************************************************************************/
	public String makeReservation(Reservation r){
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into reservations values (default, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//check number booked for flight
			String status = "waiting";
			int seatNum = 0;
			int numPass = countPassengers(r.getFlightNum());
			
			//calculate seat number
			if (numPass < CAPACITY){
				status = "confirmed";
				seatNum = ++numPass;	
			}
			
			//setting the parameters
			insertStatement.setInt(1,  r.getFlightNum());								// flight number
			insertStatement.setDouble(2, r.getSSN());									// SSN
			insertStatement.setString(3, status);                                    	// status
			insertStatement.setString(4, r.getSeatType());								// class
			insertStatement.setInt(5, seatNum);											// seat #
			insertStatement.setDouble(6, r.getAmountCharged());							// amount charged
			insertStatement.setInt(7,  r.getNumBags());									// num bags
			insertStatement.setDate(8, new java.sql.Date(System.currentTimeMillis())); 	  // date
			
			
			insertStatement.executeUpdate();
			insertStatement.close();
			return status;
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return null;
		}
	}
	
	/**********************************************************************************************************************
	 * @param flightNum - flight number to modify
	 * @param departure - new departure date
	 * @param arrival   - new arrival date
	 * @return - true on success : false on failure
	 **********************************************************************************************************************/
	public Boolean modifyFlight (int flightNum, Date departure, Date arrival) {
		try {
			PreparedStatement update = CONN.prepareStatement("UPDATE flights SET depart_time = ?, arrival_time = ? WHERE flight_number = ?");
			
			update.setTimestamp(1, new Timestamp(departure.getTime()));
			update.setTimestamp(2, new Timestamp(arrival.getTime()));
			update.setInt(3, flightNum);
			update.executeUpdate();
			update.close();
		} catch (Exception e){
			System.out.println("Failure: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	/***********************************************************************************************************************
	 * @input: none
	 * @output: none
	 * closes connection to database
	 ***********************************************************************************************************************/
	public void close(){
		try {
			if (CONN != null){
				CONN.close();
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/***********************************************************************************************************************
	 * @input: a flight number
	 * @output: number of confirmed reservations for that flight
	 ***********************************************************************************************************************/
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
	
	/*************************************************************************************************************************
	 * @input: none
	 * @output: an ArrayList<String> of all the flight numbers in the database
	 *************************************************************************************************************************/
	public ArrayList<String> getFlightNumbers( ){
		try {
			Statement query = CONN.createStatement();
			ResultSet result = query.executeQuery("SELECT flight_number FROM flights");
			
			ArrayList<String> flightNumbers = new ArrayList<String>();
			flightNumbers.add("");
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
	
	/*************************************************************************************************************************
	 * @input: none
	 * @output: an ArrayList<String> of all the SSN for each passenger in the DB
	 *************************************************************************************************************************/
	public ArrayList<String> getPassengers( ){
		try {
			Statement query = CONN.createStatement();
			ResultSet result = query.executeQuery("SELECT SSN FROM passengers");
			
			ArrayList<String> passengers = new ArrayList<String>();
			passengers.add("");
			result.first();
			
			DecimalFormat df = new DecimalFormat("#");
			
			//prime loop
			passengers.add(df.format(result.getDouble("SSN")));
			while (result.next()){
				passengers.add(df.format(result.getDouble("SSN")));
			}
			
			return passengers;
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return null;
		}
	}
	
	/***************************************************************************************************************************
	 * @param SSN - SSN of passenger to check-in
	 * @return true on success | false otherwise
	 ***************************************************************************************************************************/
	public Boolean checkIn(double SSN, int numBags, int seatNum){
		try{
			PreparedStatement query = CONN.prepareStatement("SELECT status FROM reservations WHERE SSN = ?");
			query.setDouble(1,  SSN);
			ResultSet result = query.executeQuery();
			result.first();
			
			String status = result.getString("status");
			
			if (status.equals("waiting")){
				return false;
			}
			
			Statement update = CONN.createStatement( );
			update.executeUpdate("UPDATE reservations SET status = \"checked-in\", num_bags = " + numBags + ", seat = " + seatNum + " WHERE SSN = " + SSN);
			update.close();
			query.close();
		} catch (Exception e) {
			System.out.println("Failure: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	/****************************************************************************************************************************
	 * @param flightNumber - flight number to count the on board passengers
	 * @return - count of passengers with reservation of "checked-in"
	 ****************************************************************************************************************************/
	public int countOnBoard( int flightNum ){
		int count = 0;
		try {
			PreparedStatement query = CONN.prepareStatement("SELECT count(*) FROM reservations WHERE flight_number = ? and status = \"checked-in\"");
	
			query.setInt(1, flightNum);
			ResultSet result = query.executeQuery();
			result.first();
			count = result.getInt(1);
		} catch (Exception e) {
			System.out.println("Failure! " + e.getMessage());
		}
		
		return count;
	}
	
	/*****************************************************************************************************************************
	 * @param flightNum - flight number you want the number of stops for
	 * @return - number of intermediate stops
	 *****************************************************************************************************************************/
	public int numStops( int flightNum ){
		int count = 0;
		//get count from Stops table
		return count;
	}
	
	/******************************************************************************************************************************
	 * @param flightNum
	 * @return time in minutes between departure and arrival
	 ******************************************************************************************************************************/
	public double timeTaken( int flightNum ){
		double minutes = 0;
		try {
			PreparedStatement query = CONN.prepareStatement("SELECT depart_time, arrival_time FROM flights WHERE flight_number = ?");
			query.setInt(1, flightNum);
			ResultSet result = query.executeQuery();
			result.first();
			
			Timestamp depart = result.getTimestamp("depart_time");
			Timestamp arrival = result.getTimestamp("arrival_time");
			
			minutes = arrival.getTime() - depart.getTime();
			minutes = minutes / 1000.0;   // convert to seconds
			minutes = minutes / 60.0;     // convert to minutes
			return minutes;
		} catch (Exception e){
			System.out.println("Failure: " + e.getMessage());
			return minutes;
		}
	}
	
	/*********************************************************************************************************************************
	 * @param flightNum
	 * @return ArrayList of stops in order
	 *********************************************************************************************************************************/
	public ArrayList<Stop> getStops(int flightNum){
		ArrayList<Stop> stops = new ArrayList<Stop>();
		
		//get the stops ordered by stop_number
		
		return stops;
	}
	
	
	//-----------------------------------------------------Private Methods-----------------------------------------------------------------------
	
	
	
	
	//----------------------------------------------------End Private Methods---------------------------------------------------------------------
	
	
	
	// main for testing
	public static void main(String [ ] args){
		
//		System.out.println("initializing Airline");
		Airline a = new Airline();

//		double minutes = a.timeTaken(5);
//		int hours = (int) (minutes / 60);
//		int min = (int) (minutes % 60);
//		System.out.println(hours + " Hours " + min + " Minutes");
//		Calendar cal = Calendar.getInstance();
//		Date date = new Date(System.currentTimeMillis());
//		System.out.println(date.getDate() + " " + (date.getMonth() + 1) +  " " + (date.getYear() + 1900));

//		ArrayList<String> fn = a.getFlightNumbers();
//		
//		for(int i = 0; i < fn.size(); i++){
//			System.out.println(fn.get(i));
//		}
		
//		Reservation r = new Reservation(1, 123456788, "first", 75.25, 2 );
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
