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
		CONN = DriverManager.getConnection("jdbc:mysql://localhost/airline?" + "user=root&password=password");
		} catch (Exception e) {
			System.out.println("Failure!: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public Boolean addFlight(){
		System.out.println("Adding a flight!");
		try {
			PreparedStatement insertStatement = 
					CONN.prepareStatement("INSERT into AIRLINE.FLIGHTS values (default, ?, ?, ?, ?, ?, ?)");
			
			//get date created, and set depart and arrival times
			Date today = new Date();
			Date depart = new Date(2013, 5, 30, 13, 30 );
			Date arrival = new Date(2013, 6, 1, 13, 30 );
			
			//setting the parameters
			insertStatement.setDate(1, new java.sql.Date(today.getYear(), today.getDay(), today.getMonth()));
			insertStatement.setString(2, "Boeing 737");
			insertStatement.setString(3, "Baltimore, MD");
			insertStatement.setString(4, "Seatle, WA");
			insertStatement.setTimestamp(5, new Timestamp(depart.getTime()));
			insertStatement.setTimestamp(6, new Timestamp(arrival.getTime()));
			
			//insert into database
			insertStatement.executeUpdate();
			
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	//get list of all flights
	public void getFlights() {
		
		
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
	
}
